package com.effectivejava.C_ClassesAndInterfaces.FavorCompositionOverInheritance;

import java.util.Collection;
import java.util.Set;

public class InstrumentedSet<E> extends ForwardingSet<E>{
    private int addCount=0;

    public InstrumentedSet(Set<E> mySet) {
        super(mySet);
    }

    @Override
    public boolean add(E o) {
        addCount++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        addCount++;
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }
}
