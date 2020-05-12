package de.heidelberg.pvs.diego.collectionswitch.context.impl;

import java.util.Map;

import de.heidelberg.pvs.diego.collectionswitch.context.MapAllocationContextInfo;
import de.heidelberg.pvs.diego.collectionswitch.context.MapCollectionType;
import de.heidelberg.pvs.diego.collectionswitch.optimizers.maps.MapAllocationOptimizer;

import se.lth.util.*;
import se.lth.util.concurrent.*;

public class EmpiricalMapAllocationContext implements MapAllocationContextInfo {

        private int windowSize;
        private int instancesCount;

        private MapAllocationOptimizer optimizer;

        private MapCollectionType type;

        public EmpiricalMapAllocationContext(MapCollectionType type, MapAllocationOptimizer optimizer, int windowSize) {
                super();
                this.type = type;
                this.optimizer = optimizer;
                this.windowSize = windowSize;
                this.instancesCount = 0;
        }

        @Override
        public void updateCollectionType(MapCollectionType type) {
                this.type = type;
                instancesCount = 0; // reset

        }

        @Override
        public <K, V> Map<K, V> createMap() {

                Map<K, V> map = type.createMap();

                if (instancesCount++ < windowSize) {
                        return this.optimizer.createMonitor(map);
                }

                return map;
        }

        @Override
        public <K, V> Map<K, V> createMap(int initialCapacity) {

                Map<K, V> map = type.createMap(initialCapacity);

                if (instancesCount++ < windowSize) {
                        return this.optimizer.createMonitor(map);
                }

                return map;
        }

        @Override
        public <K, V> Map<K, V> createMap(int initialCapacity, float loadFactor) {
                Map<K, V> map = type.createMap(initialCapacity);

                if (instancesCount++ < windowSize) {
                        return this.optimizer.createMonitor(map);
                }

                return map;
        }

        @Override
        public <K, V> Map<K, V> createMap(Map<K, V> mapToCopy) {
                Map<K, V> map = type.createMap(mapToCopy);

                if (instancesCount++ < windowSize) {
                        return this.optimizer.createMonitor(map);
                }

                return map;
        }

        @Override
        public MapCollectionType getCurrentCollectionType() {
                return type;
        }

    public <K, V> HashMapInterface createHashMapInterface( ) {

        HashMapInterface<K, V> map = type.createHashMapInterface();

        if (instancesCount++ < windowSize) {
            return (HashMapInterface) optimizer.createMonitor(map);
        }

        return map;

    }


    public <K, V> HashMapInterface createHashMapInterface(int initialCapacity) {

        HashMapInterface<K, V> map = type.createHashMapInterface(initialCapacity);

        if (instancesCount++ < windowSize) {
            return (HashMapInterface) optimizer.createMonitor(map);
        }

        return map;

    }


    public <K, V> HashMapInterface createHashMapInterface(Map<K, V> mapToCopy) {

        HashMapInterface<K, V> map = type.createHashMapInterface(mapToCopy);

        if (instancesCount++ < windowSize) {
            return (HashMapInterface) optimizer.createMonitor(map);
        }

        return map;

    }


    public <K, V> TreeMapInterface createTreeMapInterface( ) {

        TreeMapInterface<K, V> map = type.createTreeMapInterface();

        if (instancesCount++ < windowSize) {
            return (TreeMapInterface) optimizer.createMonitor(map);
        }

        return map;

    }


    public <K, V> TreeMapInterface createTreeMapInterface(int initialCapacity) {

        TreeMapInterface<K, V> map = type.createTreeMapInterface(initialCapacity);

        if (instancesCount++ < windowSize) {
            return (TreeMapInterface) optimizer.createMonitor(map);
        }

        return map;

    }


    public <K, V> TreeMapInterface createTreeMapInterface(Map<K, V> mapToCopy) {

        TreeMapInterface<K, V> map = type.createTreeMapInterface(mapToCopy);

        if (instancesCount++ < windowSize) {
            return (TreeMapInterface) optimizer.createMonitor(map);
        }

        return map;

    }


    public <K, V> LinkedHashMapInterface createLinkedHashMapInterface( ) {

        LinkedHashMapInterface<K, V> map = type.createLinkedHashMapInterface();

        if (instancesCount++ < windowSize) {
            return (LinkedHashMapInterface) optimizer.createMonitor(map);
        }

        return map;

    }


    public <K, V> LinkedHashMapInterface createLinkedHashMapInterface(int initialCapacity) {

        LinkedHashMapInterface<K, V> map = type.createLinkedHashMapInterface(initialCapacity);

        if (instancesCount++ < windowSize) {
            return (LinkedHashMapInterface) optimizer.createMonitor(map);
        }

        return map;

    }


    public <K, V> LinkedHashMapInterface createLinkedHashMapInterface(Map<K, V> mapToCopy) {

        LinkedHashMapInterface<K, V> map = type.createLinkedHashMapInterface(mapToCopy);

        if (instancesCount++ < windowSize) {
            return (LinkedHashMapInterface) optimizer.createMonitor(map);
        }

        return map;

    }


    public <K, V> ConcurrentSkipListMapInterface createConcurrentSkipListMapInterface( ) {

        ConcurrentSkipListMapInterface<K, V> map = type.createConcurrentSkipListMapInterface();

        if (instancesCount++ < windowSize) {
            return (ConcurrentSkipListMapInterface) optimizer.createMonitor(map);
        }

        return map;

    }


    public <K, V> ConcurrentSkipListMapInterface createConcurrentSkipListMapInterface(int initialCapacity) {

        ConcurrentSkipListMapInterface<K, V> map = type.createConcurrentSkipListMapInterface(initialCapacity);

        if (instancesCount++ < windowSize) {
            return (ConcurrentSkipListMapInterface) optimizer.createMonitor(map);
        }

        return map;

    }


    public <K, V> ConcurrentSkipListMapInterface createConcurrentSkipListMapInterface(Map<K, V> mapToCopy) {

        ConcurrentSkipListMapInterface<K, V> map = type.createConcurrentSkipListMapInterface(mapToCopy);

        if (instancesCount++ < windowSize) {
            return (ConcurrentSkipListMapInterface) optimizer.createMonitor(map);
        }

        return map;

    }
}
