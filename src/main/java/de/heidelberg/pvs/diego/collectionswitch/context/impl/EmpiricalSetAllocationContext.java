package de.heidelberg.pvs.diego.collectionswitch.context.impl;

import java.util.Collection;
import java.util.Set;

import se.lth.util.*;
import se.lth.util.concurrent.*;

import de.heidelberg.pvs.diego.collectionswitch.context.SetAllocationContextInfo;
import de.heidelberg.pvs.diego.collectionswitch.context.SetCollectionType;
import de.heidelberg.pvs.diego.collectionswitch.optimizers.sets.SetAllocationOptimizer;

public class EmpiricalSetAllocationContext  implements SetAllocationContextInfo {

        private int windowSize;
        private int instancesCount;

        private SetAllocationOptimizer optimizer;

        private SetCollectionType type;

        public EmpiricalSetAllocationContext(SetCollectionType type, SetAllocationOptimizer optimizer, int windowSize) {
                super();
                this.type = type;
                this.optimizer = optimizer;
                this.windowSize = windowSize;
                this.instancesCount = 0;
        }


        @Override
        public <E> Set<E> createSet() {
                Set<E> set = type.createSet();

                if(instancesCount++ < windowSize) {
                        return this.optimizer.createMonitor(set);
                }

                return set;

        }

        @Override
        public <E> Set<E> createSet(int initialCapacity) {

                Set<E> set = type.createSet(initialCapacity);

                if(instancesCount++ < windowSize) {
                        return this.optimizer.createMonitor(set);
                }

                return set;
        }

        @Override
        public <E> Set<E> createSet(Collection<? extends E> setToCopy) {

                Set<E> set = type.createSet(setToCopy);
                if(instancesCount++ < windowSize) {
                        return this.optimizer.createMonitor(set);
                }

                return set;
        }

    public <E> HashSetInterface createHashSetInterface( ) {

        HashSetInterface<E> set = type.createHashSetInterface();

        if (instancesCount++ < windowSize) {
            return (HashSetInterface) optimizer.createHashSetInterfaceMonitor(set);
        }

        return set;

    }


    public <E> HashSetInterface createHashSetInterface(int initialCapacity) {

        HashSetInterface<E> set = type.createHashSetInterface(initialCapacity);

        if (instancesCount++ < windowSize) {
            return (HashSetInterface) optimizer.createHashSetInterfaceMonitor(set);
        }

        return set;

    }


    public <E> HashSetInterface createHashSetInterface(Collection<? extends E> c) {

        HashSetInterface<E> set = type.createHashSetInterface(c);

        if (instancesCount++ < windowSize) {
            return (HashSetInterface) optimizer.createHashSetInterfaceMonitor(set);
        }

        return set;

    }


    public <E> LinkedHashSetInterface createLinkedHashSetInterface( ) {

        LinkedHashSetInterface<E> set = type.createLinkedHashSetInterface();

        if (instancesCount++ < windowSize) {
            return (LinkedHashSetInterface) optimizer.createLinkedHashSetInterfaceMonitor(set);
        }

        return set;

    }


    public <E> LinkedHashSetInterface createLinkedHashSetInterface(int initialCapacity) {

        LinkedHashSetInterface<E> set = type.createLinkedHashSetInterface(initialCapacity);

        if (instancesCount++ < windowSize) {
            return (LinkedHashSetInterface) optimizer.createLinkedHashSetInterfaceMonitor(set);
        }

        return set;

    }


    public <E> LinkedHashSetInterface createLinkedHashSetInterface(Collection<? extends E> c) {

        LinkedHashSetInterface<E> set = type.createLinkedHashSetInterface(c);

        if (instancesCount++ < windowSize) {
            return (LinkedHashSetInterface) optimizer.createLinkedHashSetInterfaceMonitor(set);
        }

        return set;

    }


    public <E> ConcurrentSkipListSetInterface createConcurrentSkipListSetInterface( ) {

        ConcurrentSkipListSetInterface<E> set = type.createConcurrentSkipListSetInterface();

        if (instancesCount++ < windowSize) {
            return (ConcurrentSkipListSetInterface) optimizer.createConcurrentSkipListSetInterfaceMonitor(set);
        }

        return set;

    }


    public <E> ConcurrentSkipListSetInterface createConcurrentSkipListSetInterface(int initialCapacity) {

        ConcurrentSkipListSetInterface<E> set = type.createConcurrentSkipListSetInterface(initialCapacity);

        if (instancesCount++ < windowSize) {
            return (ConcurrentSkipListSetInterface) optimizer.createConcurrentSkipListSetInterfaceMonitor(set);
        }

        return set;

    }


    public <E> ConcurrentSkipListSetInterface createConcurrentSkipListSetInterface(Collection<? extends E> c) {

        ConcurrentSkipListSetInterface<E> set = type.createConcurrentSkipListSetInterface(c);

        if (instancesCount++ < windowSize) {
            return (ConcurrentSkipListSetInterface) optimizer.createConcurrentSkipListSetInterfaceMonitor(set);
        }

        return set;

    }

        @Override
        public String getCurrentCollectionType() {
                return type.toString();
        }

        @Override
        public void updateCollectionType(SetCollectionType type) {
                this.type = type;
                this.instancesCount = 0; // reset
        }

}
