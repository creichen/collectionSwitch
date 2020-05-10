package de.heidelberg.pvs.diego.collectionswitch;

import java.util.*;
import java.util.concurrent.*;
import se.lth.util.concurrent.*;
import se.lth.util.*;

import org.eclipse.collections.impl.set.mutable.UnifiedSet;

public class UnifiedSetUniversal<E> extends UnifiedSet<E> implements HashSetInterface<E>, TreeSetInterface<E>, LinkedHashSetInterface<E>, ConcurrentSkipListSetInterface<E> {
    public UnifiedSetUniversal() {
        super();
    }

    public UnifiedSetUniversal(Collection<? extends E> coll) {
        super(coll);
    }

    public UnifiedSetUniversal(int initialCapacity) {
        // HS, LHS
        super(initialCapacity);
    }

    public UnifiedSetUniversal(int initialCapacity, float load_factor) {
        // HS, LHS
        super(initialCapacity, load_factor);
    }

    public UnifiedSetUniversal(Comparator<? super E> comparator) {
        // CSLS, TS
        super();
    }

    public UnifiedSetUniversal(SortedSet<E> s) {
        // CSLS, TS
        super(s);
    }

    @Override
    public
    E
    ceiling(E e) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public
    E
    floor(E e) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public
    E
    first() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public
    E
    last() {
        throw new java.lang.UnsupportedOperationException();
    }


    @Override
    public
    Iterator<E>
    descendingIterator() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public
    SortedSet<E>
    headSet(E e) {
        throw new java.lang.UnsupportedOperationException();
    }


    @Override
    public
    NavigableSet<E>
    headSet(E toElement, boolean inclusive) {
        throw new java.lang.UnsupportedOperationException();
    }


    @Override
    public
    E
    higher(E e) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public
    NavigableSet<E>
    descendingSet() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public
    E
    lower(E e) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public
    E
    pollFirst() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public
    E
    pollLast() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public
    NavigableSet<E>
    subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public
    SortedSet<E>
    subSet(E fromElement, E toElement) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public
    SortedSet<E>
    tailSet(E fromElement) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public
    NavigableSet<E>
    tailSet(E fromElement, boolean inclusive) {
        throw new java.lang.UnsupportedOperationException();
    }


    @Override
    public
    Comparator<? super E>
    comparator() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public java.util.Spliterator<E> spliterator() {
        throw new java.lang.UnsupportedOperationException();
    }

}
