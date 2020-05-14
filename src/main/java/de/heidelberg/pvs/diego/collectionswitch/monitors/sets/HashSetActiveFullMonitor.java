package de.heidelberg.pvs.diego.collectionswitch.monitors.sets;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import se.lth.util.*;
import se.lth.util.concurrent.*;

public class HashSetActiveFullMonitor<E> implements Set<E>, HashSetInterface<E> {
        private HashSetInterface<E> coll;
        private SetMetrics state;

        public HashSetActiveFullMonitor(HashSetInterface<E> coll, SetMetrics metrics) {
                super();
                this.coll = coll;
                this.state = metrics;
                state.updateSize(coll.size());
        }

        /**
         * MONITORED OPERATIONS
         */

        public boolean contains(Object o) {
                state.updateContainsOp(1);
                return coll.contains(o);
        }

        public Iterator<E> iterator() {
                state.updateIteration(1);
                return coll.iterator();
        }

        public boolean add(E e) {
                state.updateSize(1);
                return coll.add(e);
        }

        public boolean containsAll(Collection<?> c) {
                state.updateContainsOp(c.size());
                return coll.containsAll(c);
        }

        public boolean addAll(Collection<? extends E> c) {
                state.updateSize(c.size());
                return coll.addAll(c);
        }

        public boolean retainAll(Collection<?> c) {
                state.updateContainsOp(c.size());
                return coll.retainAll(c);
        }

        public boolean remove(Object o) {
                state.updateSize(-1);
                return coll.remove(o);
        }

        public boolean removeAll(Collection<?> c) {
                state.updateSize(-c.size());
                return coll.removeAll(c);
        }

        public void clear() {
                state.updateSize(-size());
                coll.clear();
        }

        /**
         * NON-MONITORED OPERATIONS
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

    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        throw new UnsupportedOperationException();
    }

    public java.util.Spliterator<E> spliterator() {
        throw new UnsupportedOperationException();
    }

    public java.lang.String toString() {
        throw new UnsupportedOperationException();
    }
}
