package de.heidelberg.pvs.diego.collectionswitch.optimizers.maps;


import java.util.Map;

import de.heidelberg.pvs.diego.collectionswitch.context.MapAllocationContext;
import de.heidelberg.pvs.diego.collectionswitch.optimizers.AllocationOptimizer;

import se.lth.util.*;
import se.lth.util.concurrent.*;

public interface MapAllocationOptimizer extends AllocationOptimizer {

        public <K, V> Map<K, V> createMonitor(Map<K, V> map);

        void setContext(MapAllocationContext context);

        public <K, V> HashMapInterface<K, V> createHashMapInterfaceMonitor(HashMapInterface<K, V> map);


        public <K, V> TreeMapInterface<K, V> createTreeMapInterfaceMonitor(TreeMapInterface<K, V> map);


        public <K, V> LinkedHashMapInterface<K, V> createLinkedHashMapInterfaceMonitor(LinkedHashMapInterface<K, V> map);

        public <K, V> ConcurrentSkipListMapInterface<K, V> createConcurrentSkipListMapInterfaceMonitor(ConcurrentSkipListMapInterface<K, V> map);


}
