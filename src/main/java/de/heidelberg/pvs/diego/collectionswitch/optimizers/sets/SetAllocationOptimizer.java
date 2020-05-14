package de.heidelberg.pvs.diego.collectionswitch.optimizers.sets;

import java.util.Set;

import de.heidelberg.pvs.diego.collectionswitch.context.SetAllocationContext;
import de.heidelberg.pvs.diego.collectionswitch.optimizers.AllocationOptimizer;

import se.lth.util.*;
import se.lth.util.concurrent.*;

public interface SetAllocationOptimizer extends AllocationOptimizer {

        public <E> Set<E> createMonitor(Set<E> set);

        public void analyzeAndOptimize();

        public void setContext(SetAllocationContext optimizer);

        public <E> Set<E> createHashSetInterfaceMonitor(HashSetInterface<E> set);


        public <E> Set<E> createTreeSetInterfaceMonitor(TreeSetInterface<E> set);


        public <E> Set<E> createLinkedHashSetInterfaceMonitor(LinkedHashSetInterface<E> set);


        public <E> Set<E> createConcurrentSkipListSetInterfaceMonitor(ConcurrentSkipListSetInterface<E> set);

}
