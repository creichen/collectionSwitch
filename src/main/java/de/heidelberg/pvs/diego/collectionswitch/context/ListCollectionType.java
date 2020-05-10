package de.heidelberg.pvs.diego.collectionswitch.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import se.lth.util.ArrayListUniversal;
import se.lth.util.LinkedListUniversal;

import de.heidelberg.pvs.diego.collectionswitch.adaptive.AdaptiveList;
import de.heidelberg.pvs.diego.collectionswitch.custom.lists.HashArrayListUniversal;

public enum ListCollectionType {

        JDK_ARRAYLIST,
        JDK_LINKEDLIST,
        ONLINEADAPTER_HASHARRAYLIST,
        ONLINEADAPTER_ADAPTIVELIST;

        public <E> List<E> createList(int initialCapacity) {

                switch (this) {

                case JDK_ARRAYLIST:
                        return new ArrayListUniversal<E>(initialCapacity);

                case ONLINEADAPTER_ADAPTIVELIST:
                        return new AdaptiveList<E>(initialCapacity);

                case ONLINEADAPTER_HASHARRAYLIST:
                        return new HashArrayListUniversal<E>(initialCapacity);

                case JDK_LINKEDLIST:
                        return new LinkedListUniversal<E>();

                default:
                        return new ArrayListUniversal<E>(initialCapacity);
                }

        }

        public <E> List<E> createList() {

                switch (this) {

                case JDK_ARRAYLIST:
                        return new ArrayListUniversal<E>();

                case ONLINEADAPTER_HASHARRAYLIST:
                        return new HashArrayListUniversal<E>();

                case ONLINEADAPTER_ADAPTIVELIST:
                        return new AdaptiveList<E>();

                case JDK_LINKEDLIST:
                        return new LinkedListUniversal<E>();

                default:
                        return new ArrayListUniversal<E>();

                }

        }

        public <E> List<E> createList(Collection<? extends E> c) {

                switch (this) {

                case JDK_ARRAYLIST:
                        return new ArrayListUniversal<E>(c);

                case ONLINEADAPTER_HASHARRAYLIST:
                        return new HashArrayListUniversal<E>(c);

                case ONLINEADAPTER_ADAPTIVELIST:
                        return new AdaptiveList<E>(c);

                case JDK_LINKEDLIST:
                        return new LinkedListUniversal<E>(c);

                default:
                        return new ArrayListUniversal<E>(c);
                }
        }
}
