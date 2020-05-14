package de.heidelberg.pvs.diego.collectionswitch.context;

import java.util.Map;

import se.lth.util.*;
import se.lth.util.concurrent.*;

public interface MapAllocationContext  extends AllocationContextUpdatable<MapCollectionType> {

        public <K, V> Map<K, V> createMap();

        public <K, V> Map<K, V> createMap(int initialCapacity);

        public <K, V> Map<K, V> createMap(int initialCapacity, float loadFactor);

        public <K, V> Map<K, V> createMap(Map<K, V> map);

        public <K, V> HashMapInterface createHashMapInterface( );

        public <K, V> HashMapInterface createHashMapInterface(int initialCapacity);

        public <K, V> HashMapInterface createHashMapInterface(Map<K, V> mapToCopy);

        public <K, V> TreeMapInterface createTreeMapInterface( );

        public <K, V> TreeMapInterface createTreeMapInterface(int initialCapacity);

        public <K, V> TreeMapInterface createTreeMapInterface(Map<K, V> mapToCopy);

        public <K, V> LinkedHashMapInterface createLinkedHashMapInterface( );

        public <K, V> LinkedHashMapInterface createLinkedHashMapInterface(int initialCapacity);

        public <K, V> LinkedHashMapInterface createLinkedHashMapInterface(Map<K, V> mapToCopy);

        public <K, V> ConcurrentSkipListMapInterface createConcurrentSkipListMapInterface( );

        public <K, V> ConcurrentSkipListMapInterface createConcurrentSkipListMapInterface(int initialCapacity);

        public <K, V> ConcurrentSkipListMapInterface createConcurrentSkipListMapInterface(Map<K, V> mapToCopy);

}
