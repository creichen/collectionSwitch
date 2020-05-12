package de.heidelberg.pvs.diego.collectionswitch.context;

import java.util.Collection;
import java.util.List;

import se.lth.util.*;
import se.lth.util.concurrent.*;

public interface ListAllocationContext extends AllocationContextUpdatable<ListCollectionType> {

        public <E> List<E> createList();

        public <E> List<E> createList(int initialCapacity);

        public <E> List<E> createList(Collection<? extends E> c);

        public <E> ArrayListInterface createArrayListInterface( );

        public <E> ArrayListInterface createArrayListInterface(int initialCapacity);

        public <E> ArrayListInterface createArrayListInterface(Collection<? extends E> c);

        public <E> LinkedListInterface createLinkedListInterface( );

        public <E> LinkedListInterface createLinkedListInterface(int initialCapacity);

        public <E> LinkedListInterface createLinkedListInterface(Collection<? extends E> c);

        public <E> VectorInterface createVectorInterface( );

        public <E> VectorInterface createVectorInterface(int initialCapacity);

        public <E> VectorInterface createVectorInterface(Collection<? extends E> c);
}
