package de.heidelberg.pvs.diego.collectionswitch.context;

import se.lth.util.*;
import se.lth.util.concurrent.*;

import java.util.Map;

import de.heidelberg.pvs.diego.collectionswitch.adaptive.AdaptiveMapUniversal;
import de.heidelberg.pvs.diego.collectionswitch.THashMapUniversal;
import de.heidelberg.pvs.diego.collectionswitch.UnifiedMapUniversal;
import de.heidelberg.pvs.diego.collectionswitch.CompactHashMapUniversal;
import de.heidelberg.pvs.diego.collectionswitch.nlp.ArrayMapUniversal;

import net.openhft.koloboke.collect.map.hash.HashObjObjMaps;

public enum MapCollectionType {

        JDK_HASHMAP,
        KOLOBOKE_HASHMAP,
        ONLINEADAPTER_ADAPTIVEMAP,

        JDK_LINKEDHASHMAP,

        FASTUTILS_HASHMAP,
        GSCOLLECTIONS_UNIFIEDMAP,

        NLP_ARRAYMAP,
        GOOGLE_ARRAYMAP, NAYUKI_COMPACTHASHMAP;

        public <K, V> Map<K, V> createMap(int initialCapacity) {

                switch (this) {

                case JDK_HASHMAP:
                        return new HashMapUniversal<K, V>(initialCapacity);

                case KOLOBOKE_HASHMAP:
                    throw new RuntimeException("KOLOBOKE_NOT_SUPPORTED");


                case ONLINEADAPTER_ADAPTIVEMAP:
                        return new AdaptiveMapUniversal<K, V>(initialCapacity);

                case JDK_LINKEDHASHMAP:
                        return new LinkedHashMapUniversal<K, V>(initialCapacity);

                case FASTUTILS_HASHMAP:
                        return new THashMapUniversal<K, V>(initialCapacity);

                case GSCOLLECTIONS_UNIFIEDMAP:
                        return new UnifiedMapUniversal<K, V>(initialCapacity);

                case GOOGLE_ARRAYMAP:
                        return new de.heidelberg.pvs.diego.collectionswitch.ArrayMapUniversal<K, V>();

                case NLP_ARRAYMAP:
                        return new ArrayMapUniversal<K, V>(initialCapacity);

                case NAYUKI_COMPACTHASHMAP:
                        return new CompactHashMapUniversal<K, V>();

                default:
                        return new HashMapUniversal<K, V>(initialCapacity);
                }

        }

        public <K, V> Map<K, V> createMap(int initialCapacity,
                                          float loadFactor,
                                          boolean accessOrder) {

                switch (this) {

                case JDK_HASHMAP:
                        return new HashMapUniversal<K, V>(initialCapacity, loadFactor, accessOrder);

                case KOLOBOKE_HASHMAP:
                    throw new RuntimeException("KOLOBOKE_NOT_SUPPORTED");


                case ONLINEADAPTER_ADAPTIVEMAP:
                        return new AdaptiveMapUniversal<K, V>(initialCapacity, loadFactor, accessOrder);

                case JDK_LINKEDHASHMAP:
                        return new LinkedHashMapUniversal<K, V>(initialCapacity, loadFactor, accessOrder);

                case FASTUTILS_HASHMAP:
                        return new THashMapUniversal<K, V>(initialCapacity, loadFactor, accessOrder);

                case GSCOLLECTIONS_UNIFIEDMAP:
                        return new UnifiedMapUniversal<K, V>(initialCapacity, loadFactor, accessOrder);

                case GOOGLE_ARRAYMAP:
                        return new de.heidelberg.pvs.diego.collectionswitch.ArrayMapUniversal<K, V>();

                case NLP_ARRAYMAP:
                        return new ArrayMapUniversal<K, V>(initialCapacity, loadFactor, accessOrder);

                case NAYUKI_COMPACTHASHMAP:
                        return new CompactHashMapUniversal<K, V>();

                default:
                        return new HashMapUniversal<K, V>(initialCapacity, loadFactor, accessOrder);
                }

        }
        public <K, V> Map<K, V> createMap() {


                switch (this) {

                case JDK_HASHMAP:
                        return new HashMapUniversal<K, V>();

                case KOLOBOKE_HASHMAP:
                    throw new RuntimeException("KOLOBOKE_NOT_SUPPORTED");

                case ONLINEADAPTER_ADAPTIVEMAP:
                        return new AdaptiveMapUniversal<K, V>();

                case JDK_LINKEDHASHMAP:
                        return new LinkedHashMapUniversal<K, V>();

                case FASTUTILS_HASHMAP:
                        return new THashMapUniversal<K, V>();

                case GSCOLLECTIONS_UNIFIEDMAP:
                        return new UnifiedMapUniversal<K, V>();

                case GOOGLE_ARRAYMAP:
                        return new de.heidelberg.pvs.diego.collectionswitch.ArrayMapUniversal<K, V>();

                case NLP_ARRAYMAP:
                        return new ArrayMapUniversal<K, V>();

                case NAYUKI_COMPACTHASHMAP:
                        return new CompactHashMapUniversal<K, V>();

                default:
                        return new HashMapUniversal<K, V>();
                }

        }

        public <K, V> Map<K, V> createMap(Map<K, V> mapToCopy) {

                switch (this) {

                case JDK_HASHMAP:
                        return new HashMapUniversal<K, V>(mapToCopy);

                case KOLOBOKE_HASHMAP:
                    throw new RuntimeException("KOLOBOKE_NOT_SUPPORTED");

                case ONLINEADAPTER_ADAPTIVEMAP:
                        return new AdaptiveMapUniversal<K, V>(mapToCopy);

                case JDK_LINKEDHASHMAP:
                        return new LinkedHashMapUniversal<K, V>(mapToCopy);

                case FASTUTILS_HASHMAP:
                        return new THashMapUniversal<K, V>(mapToCopy);

                case GSCOLLECTIONS_UNIFIEDMAP:
                        return new UnifiedMapUniversal<K, V>(mapToCopy);

                case GOOGLE_ARRAYMAP:
                        Map<K, V> map = new de.heidelberg.pvs.diego.collectionswitch.ArrayMapUniversal<K, V>();
                        map.putAll(mapToCopy);
                        return map;

                case NLP_ARRAYMAP:
                        return new ArrayMapUniversal<K, V>(mapToCopy);

                case NAYUKI_COMPACTHASHMAP:
                        Map<K, V> map2 = new CompactHashMapUniversal<K, V>();
                        map2.putAll(mapToCopy);
                        return map2;

                default:
                        return new HashMapUniversal<K, V>(mapToCopy);
                }
        }

        public <K, V> HashMapInterface createHashMapInterface( ) {
            return (HashMapInterface) createMap();
        }

        public <K, V> HashMapInterface createHashMapInterface(int initialCapacity) {
            return (HashMapInterface) createMap(initialCapacity);
        }

        public <K, V> HashMapInterface createHashMapInterface(Map<K, V> c) {
            return (HashMapInterface) createMap(c);
        }

        public <K, V> TreeMapInterface createTreeMapInterface( ) {
            return (TreeMapInterface) createMap();
        }

        public <K, V> TreeMapInterface createTreeMapInterface(int initialCapacity) {
            return (TreeMapInterface) createMap(initialCapacity);
        }

        public <K, V> TreeMapInterface createTreeMapInterface(Map<K, V> c) {
            return (TreeMapInterface) createMap(c);
        }

        public <K, V> LinkedHashMapInterface createLinkedHashMapInterface( ) {
            return (LinkedHashMapInterface) createMap();
        }

        public <K, V> LinkedHashMapInterface createLinkedHashMapInterface(int initialCapacity) {
            return (LinkedHashMapInterface) createMap(initialCapacity);
        }

        public <K, V> LinkedHashMapInterface createLinkedHashMapInterface(int initialCapacity,
                                                                          float loadFactor,
                                                                          boolean accessOrder) {
            return (LinkedHashMapInterface) createMap(initialCapacity,
                                                      loadFactor,
                                                      accessOrder);
        }

        public <K, V> LinkedHashMapInterface createLinkedHashMapInterface(Map<K, V> c) {

            return (LinkedHashMapInterface) createMap(c);
        }

        public <K, V> ConcurrentSkipListMapInterface createConcurrentSkipListMapInterface( ) {
            return (ConcurrentSkipListMapInterface) createMap();
        }

        public <K, V> ConcurrentSkipListMapInterface createConcurrentSkipListMapInterface(int initialCapacity) {
            return (ConcurrentSkipListMapInterface) createMap(initialCapacity);
        }

        public <K, V> ConcurrentSkipListMapInterface createConcurrentSkipListMapInterface(Map<K, V> c) {
            return (ConcurrentSkipListMapInterface) createMap(c);
        }
}
