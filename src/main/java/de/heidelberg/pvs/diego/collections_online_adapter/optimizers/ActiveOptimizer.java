package de.heidelberg.pvs.diego.collections_online_adapter.optimizers;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import de.heidelberg.pvs.diego.collections_online_adapter.context.AllocationContextUpdatable;
import de.heidelberg.pvs.diego.collections_online_adapter.context.CollectionTypeEnum;
import de.heidelberg.pvs.diego.collections_online_adapter.context.ListAllocationContext;
import de.heidelberg.pvs.diego.collections_online_adapter.utils.IntArrayUtils;

public class ActiveOptimizer implements AllocationOptimizer {

	private static final Object DUMB_OBJECT = new Object();

	private static final float ALPHA = 0.9f;

	private int sizes[];
	private AtomicInteger indexManager = new AtomicInteger(0);
	protected Map<List<?>, Object> finalizedManager;

	AllocationContextUpdatable context;

	Thread proactiveThread;

	private final int windowSize;

	private int analyzedInitialCapacity;

	private boolean firstUpdate;

	public ActiveOptimizer(int windowSize, int convergenceRate) {
		super();
		this.windowSize = windowSize;
		this.sizes = new int[windowSize];
		this.finalizedManager = new WeakHashMap<List<?>, Object>(windowSize);

	}

	@Override
	public void updateSize(int index, int size) {
		if(index < windowSize) {
			sizes[index] = size;
		}
		
	}

	protected void updateContext() {
		
		int begin = 0;
		
		if(firstUpdate) {
			analyzedInitialCapacity = sizes[0];
			firstUpdate = false;
			begin = 1;
		}
		
		for(int i = begin; i < windowSize; i++) {
			analyzedInitialCapacity = (int) (analyzedInitialCapacity * ALPHA + (1 - ALPHA) * sizes[i]);
		}
		
		this.context.updateCollectionSize(analyzedInitialCapacity);

		resetOptimizer();
	}

	private void resetOptimizer() {
		indexManager.set(0);
		finalizedManager = new WeakHashMap<List<?>, Object>(windowSize);

	}

	public void checkFinalizedAnalysis() {
		if (indexManager.get() >= windowSize) {
			if (finalizedManager.isEmpty()) {
				this.updateContext();
			}
		}
	}

	public void addReference(List<?> list) {
		this.finalizedManager.put(list, DUMB_OBJECT);

	}

	@Override
	public void setContext(AllocationContextUpdatable context) {
		this.context = context;

	}
}
