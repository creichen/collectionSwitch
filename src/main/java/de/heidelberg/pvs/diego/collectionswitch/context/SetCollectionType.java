package de.heidelberg.pvs.diego.collectionswitch.context;

import java.util.Collection;
import se.lth.util.HashSetUniversal;
import se.lth.util.LinkedHashSetUniversal;
import java.util.Set;

import org.eclipse.collections.impl.set.mutable.UnifiedSet;

import de.heidelberg.pvs.diego.collectionswitch.adaptive.AdaptiveSetUniversal;
import de.heidelberg.pvs.diego.collectionswitch.THashSetUniversal;
import edu.stanford.nlp.util.ArraySet;
import gnu.trove.set.hash.THashSet;
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
                        return new UnifiedSet<E>(initialCapacity);

                case NLP_ARRAYSET:
                        return new ArraySet<E>(initialCapacity);

                        // case ONLINEADAPTER_ARRAYSET:
                        // return new ArraySet_Naive(initialCapacity);

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
                        return new UnifiedSet<E>();

                case NLP_ARRAYSET:
                        return new ArraySet<E>();

                        // case ONLINEADAPTER_ARRAYSET:
                        // return new ArraySet_Naive(initialCapacity);

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
                        return new UnifiedSet<E>(setToCopy);

                case NLP_ARRAYSET:
                        Set<E> set2 = new ArraySet<E>();
                        set2.addAll(setToCopy);
                        return set2;

                        // case ONLINEADAPTER_ARRAYSET:
                        // return new ArraySet_Naive(initialCapacity);

                case ONLINEADAPTER_ADAPTIVESET:
                        return new AdaptiveSetUniversal<E>(setToCopy);

                default:
                        return new HashSetUniversal<E>(setToCopy);
                }

        }
}
