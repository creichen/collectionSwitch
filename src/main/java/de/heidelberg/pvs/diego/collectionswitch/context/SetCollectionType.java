package de.heidelberg.pvs.diego.collectionswitch.context;

import java.util.Collection;
import se.lth.util.HashSetUniversal;
import se.lth.util.LinkedHashSetUniversal;
import java.util.Set;

import se.lth.util.*;
import se.lth.util.concurrent.*;

import de.heidelberg.pvs.diego.collectionswitch.adaptive.AdaptiveSetUniversal;
import de.heidelberg.pvs.diego.collectionswitch.THashSetUniversal;
import de.heidelberg.pvs.diego.collectionswitch.UnifiedSetUniversal;
import de.heidelberg.pvs.diego.collectionswitch.ArraySetUniversal;
import net.openhft.koloboke.collect.set.hash.HashObjSets;

public enum SetCollectionType {

        JDK_HASHSET, JDK_LINKEDHASHSET,

        FASTUTILS_HASHSET, GSCOLLECTIONS_UNIFIEDSET, KOLOBOKE_HASHSET,

        NLP_ARRAYSET,
        // ONLINEADAPTER_ARRAYSET,
        ONLINEADAPTER_ADAPTIVESET;

        public <E> Set<E> createSet(int initialCapacity) {

                switch (this) {

                case JDK_HASHSET:
                        return new HashSetUniversal<E>(initialCapacity);

                case KOLOBOKE_HASHSET:
                        return HashObjSets.newMutableSet(initialCapacity);

                case JDK_LINKEDHASHSET:
                        return new LinkedHashSetUniversal<E>(initialCapacity);

                case FASTUTILS_HASHSET:
                        return new THashSetUniversal<E>(initialCapacity);

                case GSCOLLECTIONS_UNIFIEDSET:
                        return new UnifiedSetUniversal<E>(initialCapacity);

                case NLP_ARRAYSET:
                        return new ArraySetUniversal<E>(initialCapacity);

                        // case ONLINEADAPTER_ARRAYSET:
                        // return new ArraySetUniversal_Naive(initialCapacity);

                case ONLINEADAPTER_ADAPTIVESET:
                        return new AdaptiveSetUniversal<E>(initialCapacity);

                default:
                        return new HashSetUniversal<E>(initialCapacity);
                }

        }

        public <E> Set<E> createSet() {


                switch (this) {

                case JDK_HASHSET:
                        return new HashSetUniversal<E>();

                case KOLOBOKE_HASHSET:
                        return HashObjSets.newMutableSet();

                case JDK_LINKEDHASHSET:
                        return new LinkedHashSetUniversal<E>();

                case FASTUTILS_HASHSET:
                        return new THashSetUniversal<E>();

                case GSCOLLECTIONS_UNIFIEDSET:
                        return new UnifiedSetUniversal<E>();

                case NLP_ARRAYSET:
                        return new ArraySetUniversal<E>();

                        // case ONLINEADAPTER_ARRAYSET:
                        // return new ArraySetUniversal_Naive(initialCapacity);

                case ONLINEADAPTER_ADAPTIVESET:
                        return new AdaptiveSetUniversal<E>();

                default:
                        return new HashSetUniversal<E>();
                }

        }


        public <E> Set<E> createSet(Collection<? extends E> setToCopy) {

                switch (this) {

                case JDK_HASHSET:
                        return new HashSetUniversal<E>(setToCopy);

                case KOLOBOKE_HASHSET:
                        return HashObjSets.newMutableSet(setToCopy);

                case JDK_LINKEDHASHSET:
                        return new LinkedHashSetUniversal<E>(setToCopy);

                case FASTUTILS_HASHSET:
                        return new THashSetUniversal<E>(setToCopy);

                case GSCOLLECTIONS_UNIFIEDSET:
                        return new UnifiedSetUniversal<E>(setToCopy);

                case NLP_ARRAYSET:
                        Set<E> set2 = new ArraySetUniversal<E>();
                        set2.addAll(setToCopy);
                        return set2;

                        // case ONLINEADAPTER_ARRAYSET:
                        // return new ArraySetUniversal_Naive(initialCapacity);

                case ONLINEADAPTER_ADAPTIVESET:
                        return new AdaptiveSetUniversal<E>(setToCopy);

                default:
                        return new HashSetUniversal<E>(setToCopy);
                }

        }

        public <E> HashSetInterface<E> createSetHashSetInterface( ) {
            return (HashSetInterface) createSet();
        }

        public <E> HashSetInterface<E> createSetHashSetInterface(int initialCapacity) {
            return (HashSetInterface) createSet(initialCapacity);
        }

        public <E> HashSetInterface<E> createSetHashSetInterface(Collection<? extends E> c) {
            return (HashSetInterface) createSet(c);
        }

        public <E> TreeSetInterface<E> createSetTreeSetInterface( ) {
            return (TreeSetInterface) createSet();
        }

        public <E> TreeSetInterface<E> createSetTreeSetInterface(int initialCapacity) {
            return (TreeSetInterface) createSet(initialCapacity);
        }

        public <E> TreeSetInterface<E> createSetTreeSetInterface(Collection<? extends E> c) {
            return (TreeSetInterface) createSet(c);
        }

        public <E> LinkedHashSetInterface<E> createSetLinkedHashSetInterface( ) {
            return (LinkedHashSetInterface) createSet();
        }

        public <E> LinkedHashSetInterface<E> createSetLinkedHashSetInterface(int initialCapacity) {
            return (LinkedHashSetInterface) createSet(initialCapacity);
        }

        public <E> LinkedHashSetInterface<E> createSetLinkedHashSetInterface(Collection<? extends E> c) {
            return (LinkedHashSetInterface) createSet(c);
        }

        public <E> ConcurrentSkipListSetInterface<E> createSetConcurrentSkipListSetInterface( ) {
            return (ConcurrentSkipListSetInterface) createSet();
        }

        public <E> ConcurrentSkipListSetInterface<E> createSetConcurrentSkipListSetInterface(int initialCapacity) {
            return (ConcurrentSkipListSetInterface) createSet(initialCapacity);
        }

        public <E> ConcurrentSkipListSetInterface<E> createSetConcurrentSkipListSetInterface(Collection<? extends E> c) {
            return (ConcurrentSkipListSetInterface) createSet(c);
        }
}
