package de.heidelberg.pvs.diego.collectionswitch.monitors.lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import se.lth.util.*;
import se.lth.util.concurrent.*;

public class VectorActiveFullMonitor<E> implements List<E>, VectorInterface<E> {
        private VectorInterface<E> coll;
        private ListMetrics state;

        public VectorActiveFullMonitor(VectorInterface<E> coll, ListMetrics metrics) {
                super();
                this.coll = coll;
                this.state = metrics;
                state.updateSize(coll.size());
        }

    /**
     * MONITORED OPERATIONS
     */

    public boolean contains(Object o) {
        this.state.updateContainsOp(1);
        return coll.contains(o);
    }

    public Iterator<E> iterator() {
        this.state.updateIteratorOp(1);
        return coll.iterator();
    }

    public boolean add(E e) {
        this.state.updateSize(1);
        return coll.add(e);
    }

    public boolean containsAll(Collection<?> c) {
        this.state.updateContainsOp(c.size());
        return coll.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        this.state.updateSize(c.size());
        return coll.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        this.state.updateSize(c.size());
        return coll.addAll(index, c);
    }

    public boolean retainAll(Collection<?> c) {
        this.state.updateContainsOp(c.size());
        return coll.retainAll(c);
    }

    public E get(int index) {
        this.state.updateIndexOp(1);
        return coll.get(index);
    }

    public void add(int index, E element) {
        this.state.updateIndexOp(1);
        this.state.updateSize(1);
        coll.add(index, element);
    }

    public int indexOf(Object o) {
        this.state.updateContainsOp(1);
        return coll.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        this.state.updateContainsOp(1);
        return coll.lastIndexOf(o);
    }

    public ListIterator<E> listIterator() {
        this.state.updateIteratorOp(1);
        return coll.listIterator();
    }

    public ListIterator<E> listIterator(int index) {
        this.state.updateIteratorOp(1);
        return coll.listIterator(index);
    }

    public E set(int index, E element) {
        state.updateIndexOp(1);
        return coll.set(index, element);
    }

    public boolean remove(Object o) {
        state.updateContainsOp(1);
        boolean remove = coll.remove(o);
        if(remove) state.updateSize(-1);
        return remove;
    }

    public boolean removeAll(Collection<?> c) {
        state.updateSize(-c.size());
        return coll.removeAll(c);
    }


    public E remove(int index) {
        state.updateSize(1);
        return coll.remove(index);
    }

    public void clear() {
        state.updateSize(-size());
        coll.clear();
    }


    /**
     * NON_MONITORED OPERATIONS
     */

    public int size() {
        return coll.size();
    }

    public boolean isEmpty() {
        return coll.isEmpty();
    }

    public Object[] toArray() {
        return coll.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return coll.toArray(a);
    }

    public boolean equals(Object o) {
        return coll.equals(o);
    }

    public int hashCode() {
        return coll.hashCode();
    }
    public List<E> subList(int fromIndex, int toIndex) {
        return coll.subList(fromIndex, toIndex);
    }

    public java.util.Spliterator<E> spliterator() {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    public void removeRange(int __sm_arg_0, int __sm_arg_1) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        throw new java.lang.CloneNotSupportedException();
    }

    public void
        sort(java.util.Comparator<? super E> comparator) {
        coll.sort(comparator);
    }

    public boolean removeLastOccurrence(java.lang.Object __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public E removeLast() {
        throw new java.lang.UnsupportedOperationException();
    }

    public void addFirst(E __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.Iterator<E> descendingIterator() {
        throw new java.lang.UnsupportedOperationException();
    }

    public E element() {
        throw new java.lang.UnsupportedOperationException();
    }

    public E getFirst() {
        throw new java.lang.UnsupportedOperationException();
    }

    public E getLast() {
        throw new java.lang.UnsupportedOperationException();
    }

    public boolean offer(E __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public boolean offerFirst(E __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public boolean offerLast(E __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public E peek() {
        throw new java.lang.UnsupportedOperationException();
    }

    public E peekFirst() {
        throw new java.lang.UnsupportedOperationException();
    }

    public E peekLast() {
        throw new java.lang.UnsupportedOperationException();
    }

    public E poll() {
        throw new java.lang.UnsupportedOperationException();
    }

    public E pollFirst() {
        throw new java.lang.UnsupportedOperationException();
    }

    public E pollLast() {
        throw new java.lang.UnsupportedOperationException();
    }

    public E pop() {
        throw new java.lang.UnsupportedOperationException();
    }

    public void push(E __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public E remove() {
        throw new java.lang.UnsupportedOperationException();
    }

    public E removeFirst() {
        throw new java.lang.UnsupportedOperationException();
    }

    public boolean removeFirstOccurrence(java.lang.Object __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public void removeAllElements() {
        state.updateSize(-size());
        coll.removeAllElements();
    }

    public E elementAt(int i) {
        this.state.updateIndexOp(1);
        return coll.elementAt(i);
    }

    public void addElement(E elem) {
        this.state.updateSize(1);
        coll.add(elem);
    }
}
