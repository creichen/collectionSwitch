package de.heidelberg.pvs.diego.collectionswitch.adaptive;

import java.util.*;
import java.util.function.BiFunction;
import java.util.concurrent.*;
import se.lth.util.concurrent.*;
import se.lth.util.*;

public class AdaptiveMapUniversal<K, V> extends AdaptiveMap<K, V> implements HashMapInterface<K, V>, TreeMapInterface<K, V>, LinkedHashMapInterface<K, V> {
    public AdaptiveMapUniversal() {
        super();
    }

    public AdaptiveMapUniversal(Map<? extends K,? extends V> m) {
        super(m);
    }

    public AdaptiveMapUniversal(int initialCapacity) {
        // HM, LHM
        super(initialCapacity);
    }

    public AdaptiveMapUniversal(int initialCapacity, float loadFactor) {
        // HM, LHM
        super(initialCapacity, loadFactor);
    }

    public AdaptiveMapUniversal(int initialCapacity, float loadFactor, boolean accessOrder) {
        // LHM
        super(initialCapacity, loadFactor);
    }

    public AdaptiveMapUniversal(Comparator<? super K> comparator) {
        // TM, CSLM
        super();
    }

    public AdaptiveMapUniversal(SortedMap<K,? extends V> m) {
        // TM, CSLM
        super(m);
    }

    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        throw new java.lang.CloneNotSupportedException();
    }

    @Override
    public boolean remove(java.lang.Object __sm_arg_0, java.lang.Object __sm_arg_1) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public void replaceAll(BiFunction<? super K,? super V,? extends V> function) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public V replace(K key, V value) {
        throw new java.lang.UnsupportedOperationException();
    }

    public V putIfAbsent(K __sm_arg_0, V __sm_arg_1) {
        throw new java.lang.UnsupportedOperationException();
    }

    public V merge(K __sm_arg_0, V __sm_arg_1, java.util.function.BiFunction<? super V, ? super V, ? extends V> __sm_arg_2) {
        throw new java.lang.UnsupportedOperationException();
    }

    public V getOrDefault(java.lang.Object __sm_arg_0, V __sm_arg_1) {
        throw new java.lang.UnsupportedOperationException();
    }

    public void forEach(java.util.function.BiConsumer<? super K, ? super V> __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public V computeIfPresent(K __sm_arg_0, java.util.function.BiFunction<? super K, ? super V, ? extends V> __sm_arg_1) {
        throw new java.lang.UnsupportedOperationException();
    }

    public V computeIfAbsent(K __sm_arg_0, java.util.function.Function<? super K, ? extends V> __sm_arg_1) {
        throw new java.lang.UnsupportedOperationException();
    }

    public V compute(K __sm_arg_0, java.util.function.BiFunction<? super K, ? super V, ? extends V> __sm_arg_1) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean replace(K __sm_arg_0, V __sm_arg_1, V __sm_arg_2) {
        throw new java.lang.UnsupportedOperationException();
    }

    public ConcurrentNavigableMap<K, V> tailMap(K __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public ConcurrentNavigableMap<K, V> tailMap(K __sm_arg_0, boolean _b) {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.NavigableSet<K> keySet() {
        return AdaptiveMapUniversal.navigableSet(super.keySet());
    }

    public ConcurrentNavigableMap<K, V> headMap(K __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public ConcurrentNavigableMap<K, V> headMap(K __sm_arg_0, boolean _b) {
        throw new java.lang.UnsupportedOperationException();
    }

    public K lastKey() {
        throw new java.lang.UnsupportedOperationException();
    }

    public K firstKey() {
        throw new java.lang.UnsupportedOperationException();
    }

    public ConcurrentNavigableMap<K, V> subMap(K __sm_arg_0, K __sm_arg_1) {
        throw new java.lang.UnsupportedOperationException();
    }

    public ConcurrentNavigableMap<K, V> subMap(K __sm_arg_0, boolean _b0, K __sm_arg_1, boolean _b1) {
        throw new java.lang.UnsupportedOperationException();
    }

    // public java.util.Collection<V> values() {
    //     throw new java.lang.UnsupportedOperationException();
    // }

    public java.util.Comparator<? super K> comparator() {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> pollLastEntry() {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> pollFirstEntry() {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.NavigableSet<K> navigableKeySet() {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> lowerEntry(K __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> lastEntry() {
        throw new java.lang.UnsupportedOperationException();
    }

    public K lowerKey(K __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public K higherKey(K __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> higherEntry(K __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public K floorKey(K __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> floorEntry(K __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> firstEntry() {
        throw new java.lang.UnsupportedOperationException();
    }

    public ConcurrentNavigableMap<K, V> descendingMap() {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.NavigableSet<K> descendingKeySet() {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> ceilingEntry(K __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public K ceilingKey(K __sm_arg_0) {
        throw new java.lang.UnsupportedOperationException();
    }

    public static <E> NavigableSet<E> navigableSet(final Set<E> set) {
        return (new NavigableSet<E>() {

                @Override
                public Comparator<? super E> comparator() {
                        return null;
                }

                @Override
                public E first() {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public E last() {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public int size() {
                        return set.size();
                }

                @Override
                public boolean isEmpty() {
                        return set.isEmpty();
                }

                @Override
                public boolean contains(Object o) {
                        return set.contains(o);
                }

                @Override
                public Object[] toArray() {
                        return set.toArray();
                }

                @Override
                public <T> T[] toArray(T[] a) {
                        return set.toArray(a);
                }

                @Override
                public boolean add(E e) {
                        return set.add(e);
                }

                @Override
                public boolean remove(Object o) {
                        return set.remove(o);
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                        return set.containsAll(c);
                }

                @Override
                public boolean addAll(Collection<? extends E> c) {
                        return set.addAll(c);
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                        return set.retainAll(c);
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                        return set.removeAll(c);
                }

                @Override
                public void clear() {
                        set.clear();
                }

                @Override
                public E lower(E e) {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public E floor(E e) {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public E ceiling(E e) {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public E higher(E e) {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public E pollFirst() {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public E pollLast() {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public Iterator<E> iterator() {
                        return set.iterator();
                }

                @Override
                public NavigableSet<E> descendingSet() {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public Iterator<E> descendingIterator() {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public NavigableSet<E> headSet(E toElement, boolean inclusive) {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public SortedSet<E> subSet(E fromElement, E toElement) {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public SortedSet<E> headSet(E toElement) {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public SortedSet<E> tailSet(E fromElement) {
                        throw new java.lang.UnsupportedOperationException();
                }

                @Override
                public boolean
                equals(Object other) {
                    return set.equals(other);
                }

                @Override
                public String
                toString() {
                        return set.toString();
                }

                @Override
                public int
                hashCode() {
                        return set.hashCode();
                }
            });
    }
}
