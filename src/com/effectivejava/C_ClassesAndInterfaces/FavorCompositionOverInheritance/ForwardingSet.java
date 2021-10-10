package com.effectivejava.C_ClassesAndInterfaces.FavorCompositionOverInheritance;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ForwardingSet<E> implements Set<E> {
    private final Set<E> mySet;

    public ForwardingSet(Set<E> mySet) {
        this.mySet = mySet;
    }

    @Override
    public int size() {
        return mySet.size();
    }

    @Override
    public boolean isEmpty() {
        return mySet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return mySet.contains(o);
    }

    @Override
    public Iterator iterator() {
        return mySet.iterator();
    }

    @Override
    public Object[] toArray() {
        return mySet.toArray();
    }

    @Override
    public boolean add(E o) {
        return mySet.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return mySet.remove(o) ;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return mySet.addAll(c);
    }

    @Override
    public void clear() {
        mySet.clear();
    }

    @Override
    public boolean equals(Object o) {
        return mySet.equals(o);
    }

    @Override
    public int hashCode() {
        return mySet.hashCode();
    }

    @Override
    public boolean removeAll(Collection c) {
        return mySet.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return mySet.retainAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return mySet.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return mySet.toArray(a);
    }
}
