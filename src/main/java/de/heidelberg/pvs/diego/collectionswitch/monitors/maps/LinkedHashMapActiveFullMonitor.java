package de.heidelberg.pvs.diego.collectionswitch.monitors.maps;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import se.lth.util.*;
import se.lth.util.concurrent.*;

public class LinkedHashMapActiveFullMonitor<K, V> implements Map<K, V>, LinkedHashMapInterface<K, V> {
        private LinkedHashMapInterface<K, V> coll;
        private MapMetrics state;

        public LinkedHashMapActiveFullMonitor(LinkedHashMapInterface<K, V> coll, MapMetrics metrics) {
                super();
                this.coll = coll;
                this.state = metrics;
                state.updateSize(coll.size());
        }

        public boolean containsKey(Object key) {
                this.state.updateContainsOp(1);
                return coll.containsKey(key);
        }

        public boolean containsValue(Object value) {
                this.state.updateContainsOp(1);
                return coll.containsValue(value);
        }

        public V get(Object key) {
                this.state.updateContainsOp(1);
                return coll.get(key);
        }

        public V put(K key, V value) {
                this.state.updateSize(1);
                return coll.put(key, value);
        }

        public Set<java.util.Map.Entry<K, V>> entrySet() {
                state.updateIteration(1);
                return coll.entrySet();
        }

        public void putAll(Map<? extends K, ? extends V> m) {
                state.updateSize(m.size());
                coll.putAll(m);
        }

        public Set<K> keySet() {
                state.updateIteration(1);
                return coll.keySet();
        }

        public Collection<V> values() {
                state.updateIteration(1);
                return coll.values();
        }

        public V remove(Object key) {
                state.updateSize(-1);
                return coll.remove(key);
        }

        // --------------------------

        public int size() {
                return coll.size();
        }

        public boolean isEmpty() {
                return coll.isEmpty();
        }

        public void clear() {
                state.updateSize(-coll.size());
                coll.clear();
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

    public V compute(K __sm_arg_0, java.util.function.BiFunction<? super K, ? super V, ? extends V> __sm_arg_1) {
        throw new UnsupportedOperationException();
    }

    public V computeIfAbsent(K __sm_arg_0, java.util.function.Function<? super K, ? extends V> __sm_arg_1) {
        throw new UnsupportedOperationException();
    }

    public V computeIfPresent(K __sm_arg_0, java.util.function.BiFunction<? super K, ? super V, ? extends V> __sm_arg_1) {
        throw new UnsupportedOperationException();
    }

    public void forEach(java.util.function.BiConsumer<? super K, ? super V> __sm_arg_0) {
        throw new UnsupportedOperationException();
    }

    public V getOrDefault(java.lang.Object __sm_arg_0, V __sm_arg_1) {
        throw new UnsupportedOperationException();
    }

    public V merge(K __sm_arg_0, V __sm_arg_1, java.util.function.BiFunction<? super V, ? super V, ? extends V> __sm_arg_2) {
        throw new UnsupportedOperationException();
    }

    public V putIfAbsent(K __sm_arg_0, V __sm_arg_1) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(java.lang.Object __sm_arg_0, java.lang.Object __sm_arg_1) {
        throw new UnsupportedOperationException();
    }

    public boolean replace(K __sm_arg_0, V __sm_arg_1, V __sm_arg_2) {
        throw new UnsupportedOperationException();
    }

    public V replace(K __sm_arg_0, V __sm_arg_1) {
        throw new UnsupportedOperationException();
    }

    public void replaceAll(java.util.function.BiFunction<? super K, ? super V, ? extends V> __sm_arg_0) {
        throw new UnsupportedOperationException();
    }

    public java.lang.String toString() {
        throw new UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> ceilingEntry(K __sm_arg_0) {
        throw new UnsupportedOperationException();
    }

    public K ceilingKey(K __sm_arg_0) {
        throw new UnsupportedOperationException();
    }

    public java.util.NavigableSet<K> descendingKeySet() {
        throw new UnsupportedOperationException();
    }

    public java.util.NavigableMap<K, V> descendingMap() {
        throw new UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> firstEntry() {
        throw new UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> floorEntry(K __sm_arg_0) {
        throw new UnsupportedOperationException();
    }

    public K floorKey(K __sm_arg_0) {
        throw new UnsupportedOperationException();
    }

    public java.util.NavigableMap<K, V> headMap(K __sm_arg_0, boolean __sm_arg_1) {
        throw new UnsupportedOperationException();
    }

    public java.util.SortedMap<K, V> headMap(K __sm_arg_0) {
        throw new UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> higherEntry(K __sm_arg_0) {
        throw new UnsupportedOperationException();
    }

    public K higherKey(K __sm_arg_0) {
        throw new UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> lastEntry() {
        throw new UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> lowerEntry(K __sm_arg_0) {
        throw new UnsupportedOperationException();
    }

    public K lowerKey(K __sm_arg_0) {
        throw new UnsupportedOperationException();
    }

    public java.util.NavigableSet<K> navigableKeySet() {
        throw new UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    public java.util.Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public java.util.NavigableMap<K, V> subMap(K __sm_arg_0, boolean __sm_arg_1, K __sm_arg_2, boolean __sm_arg_3) {
        throw new UnsupportedOperationException();
    }

    public java.util.SortedMap<K, V> subMap(K __sm_arg_0, K __sm_arg_1) {
        throw new UnsupportedOperationException();
    }

    public java.util.NavigableMap<K, V> tailMap(K __sm_arg_0, boolean __sm_arg_1) {
        throw new UnsupportedOperationException();
    }

    public java.util.SortedMap<K, V> tailMap(K __sm_arg_0) {
        throw new UnsupportedOperationException();
    }

    public K firstKey() {
        throw new UnsupportedOperationException();
    }

    public K lastKey() {
        throw new UnsupportedOperationException();
    }

    public java.util.Comparator comparator() {
        throw new UnsupportedOperationException();
    }
}
