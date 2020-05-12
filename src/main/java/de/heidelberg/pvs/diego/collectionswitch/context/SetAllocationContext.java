package de.heidelberg.pvs.diego.collectionswitch.context;

import java.util.Collection;
import java.util.Set;

import se.lth.util.*;
import se.lth.util.concurrent.*;

public interface SetAllocationContext extends AllocationContextUpdatable<SetCollectionType> {

        public <E> Set<E> createSet();

        public <E> Set<E> createSet(int initialCapacity);

        public <E> Set<E> createSet(Collection<? extends E> set);

        public <E> HashSetInterface createHashSetInterface( );

        public <E> HashSetInterface createHashSetInterface(int initialCapacity);

        public <E> HashSetInterface createHashSetInterface(Collection<? extends E> c);

        public <E> TreeSetInterface createTreeSetInterface( );

        public <E> TreeSetInterface createTreeSetInterface(int initialCapacity);

        public <E> TreeSetInterface createTreeSetInterface(Collection<? extends E> c);

        public <E> LinkedHashSetInterface createLinkedHashSetInterface( );

        public <E> LinkedHashSetInterface createLinkedHashSetInterface(int initialCapacity);

        public <E> LinkedHashSetInterface createLinkedHashSetInterface(Collection<? extends E> c);

        public <E> ConcurrentSkipListSetInterface createConcurrentSkipListSetInterface( );

        public <E> ConcurrentSkipListSetInterface createConcurrentSkipListSetInterface(int initialCapacity);

        public <E> ConcurrentSkipListSetInterface createConcurrentSkipListSetInterface(Collection<? extends E> c);
}
