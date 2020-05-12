package de.heidelberg.pvs.diego.collectionswitch.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import se.lth.util.*;

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
        public <E> ArrayListInterface<E> createArrayListInterface( ) {
            return (ArrayListInterface) createList();
        }

        public <E> ArrayListInterface<E> createArrayListInterface(int initialCapacity) {
            return (ArrayListInterface) createList(initialCapacity);
        }

        public <E> ArrayListInterface<E> createArrayListInterface(Collection<? extends E> c) {
            return (ArrayListInterface) createList(c);
        }

        public <E> LinkedListInterface<E> createLinkedListInterface( ) {
            return (LinkedListInterface) createList();
        }

        public <E> LinkedListInterface<E> createLinkedListInterface(int initialCapacity) {
            return (LinkedListInterface) createList(initialCapacity);
        }

        public <E> LinkedListInterface<E> createLinkedListInterface(Collection<? extends E> c) {
            return (LinkedListInterface) createList(c);
        }

        public <E> VectorInterface<E> createVectorInterface( ) {
            return (VectorInterface) createList();
        }

        public <E> VectorInterface<E> createVectorInterface(int initialCapacity) {
            return (VectorInterface) createList(initialCapacity);
        }

        public <E> VectorInterface<E> createVectorInterface(Collection<? extends E> c) {
            return (VectorInterface) createList(c);
        }
}
