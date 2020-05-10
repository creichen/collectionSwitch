package de.heidelberg.pvs.diego.collectionswitch;

import java.util.*;
import java.util.concurrent.*;
import se.lth.util.concurrent.*;
import se.lth.util.*;
import gnu.trove.set.hash.THashSet;

public class THashSetUniversal<E> extends THashSet<E> implements HashSetInterface<E>, TreeSetInterface<E>, LinkedHashSetInterface<E>, ConcurrentSkipListSetInterface<E> {
    public THashSetUniversal() {
        super();
    }

    public THashSetUniversal(Collection<? extends E> coll) {
        super(coll);
    }

    public THashSetUniversal(int initialCapacity) {
        // HS, LHS
        super(initialCapacity);
    }

    public THashSetUniversal(int initialCapacity, float load_factor) {
        // HS, LHS
        super(initialCapacity, load_factor);
    }

    public THashSetUniversal(Comparator<? super E> comparator) {
        // CSLS, TS
        super();
    }

    public THashSetUniversal(SortedSet<E> s) {
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

    @Override
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        throw new java.lang.CloneNotSupportedException();
    }
}
