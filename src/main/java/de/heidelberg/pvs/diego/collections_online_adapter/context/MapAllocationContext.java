package de.heidelberg.pvs.diego.collections_online_adapter.context;

import java.util.Map;

public interface MapAllocationContext  {
	
	public <K, V> Map<K, V> createMap();

	public <K, V> Map<K, V> createMap(int initialCapacity);

	public <K, V> Map<K, V> createMap(Map<K, V> map);

}
