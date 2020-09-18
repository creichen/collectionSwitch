package de.heidelberg.pvs.diego.collectionswitch.adaptive;

import java.util.*;
import java.util.concurrent.*;
import se.lth.util.concurrent.*;
import se.lth.util.*;

public class AdaptiveListUniversal<E> extends AdaptiveList<E> implements LinkedListInterface<E>, ArrayListInterface<E>, VectorInterface<E> {
    public AdaptiveListUniversal() {
        super();
    }

    public AdaptiveListUniversal(Collection<? extends E> coll) {
        super(coll);
    }

    public AdaptiveListUniversal(int initial_capacity) {
        // AdaptiveList, Vector
        super(initial_capacity);
    }

    public AdaptiveListUniversal(int initial_capacity, int increment) {
        // Vector
        super(initial_capacity);
    }

    public void
    sort(java.util.Comparator<? super E> comparator) {
        super.sort(comparator);
    }

    public void replaceAll(java.util.function.UnaryOperator<E> other) {
        super.replaceAll(other);
    }

    // public void
    // removeRange(int i0, int i1) {
    //     super.removeRange(i0, i1);
    // }

    // @Override
    // public int size() {
    //	int count = 0;
    //	for (E obj : this) {
    //	    ++count;
    //	}
    //	return count;
    // }

    // @Override
    // public ListIterator<E>
    // listIterator(int index) {
    //	throw new RuntimeException("Missing implementation");
    // }

    @Override
    public E removeLast() {
        int offset = this.size() - 1;
        if (offset == -1) {
            throw new NoSuchElementException();
        }
        return this.remove(offset);
    }

    @Override
    public E pollLast() {
        int offset = this.size() - 1;
        if (offset == -1) {
            return null;
        }
        return this.get(offset);
    }

    @Override
    public E remove() {
        return this.removeFirst();
    }

    @Override
    public java.util.Iterator<E> descendingIterator() {
        @SuppressWarnings("unchecked")
        E[] array = this.toArray((E[]) new Object[this.size()]);
        List<E> list = Arrays.asList(array);
        Collections.reverse(list);
        return list.iterator();
    }

    @Override
    public E pop() {
        return this.removeLast();
    }

    @Override
    public void addLast(E elt) {
        this.add(elt);
    }

    @Override
    public void addElement(E elt) {
        this.add(elt);
    }

    @Override
    public void removeAllElements() {
        this.clear();
    }

    @Override
    public E peek() {
        return this.peekFirst();
    }

    @Override
    public void addFirst(E elt) {
        this.add(0, elt);
    }

    @Override
    public boolean offerLast(E elt) {
        return this.add(elt);
    }

    @Override
    public E getLast() {
        int offset = this.size() - 1;
        if (offset == -1) {
            throw new NoSuchElementException();
        }
        return this.get(offset);
    }

    @Override
    public boolean offerFirst(E elt) {
        this.add(0, elt);
        return true;
    }

    @Override
    public E poll() {
        return this.get(0);
    }

    @Override
    public boolean removeLastOccurrence(java.lang.Object sought) {
        for (int i = this.size() - 1; i >= 0; --i) {
            E elt = this.get(i);
            if (elt == null) {
                if (sought == null) {
                    this.remove(i);
                    return true;
                } else if (elt.equals(sought)) {
                    this.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E element() {
        return this.get(0);
    }

    @Override
    public E getFirst() {
        return this.get(0);
    }

    @Override
    public E removeFirst() {
        return this.remove(0);
    }

    @Override
    public boolean offer(E elt) {
        return this.add(elt);
    }

    @Override
    public void push(E elt) {
        this.add(elt);
    }

    @Override
    public E peekFirst() {
        if (this.isEmpty()) {
            return  null;
        }
        return this.remove(0);
    }

    @Override
    public E peekLast() {
        int offset = this.size() - 1;
        if (offset == -1) {
            return null;
        }
        return this.get(offset);
    }

    @Override
    public E pollFirst() {
        if (this.isEmpty()) {
            return null;
        }
        return this.get(0);
    }

    @Override
    public boolean removeFirstOccurrence(java.lang.Object sought) {
        for (int i = 0; i < this.size(); ++i) {
            E elt = this.get(i);
            if (elt == null) {
                if (sought == null) {
                    this.remove(i);
                    return true;
                } else if (elt.equals(sought)) {
                    this.remove(i);
                    return true;
                }
            }
        }
        return false;
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

    public E elementAt(int i) {
        return this.get(i);
    }

    public void ensureCapacity(int c) {}

    public void trimToSize() {}
}
