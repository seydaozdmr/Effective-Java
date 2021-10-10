package com.effectivejava.C_ClassesAndInterfaces.FavorCompositionOverInheritance;

import java.util.Collection;
import java.util.HashSet;

//hashset sınıfını extend ediyoruz
public class IncrementedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public IncrementedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);

    }

    /**
     * Eğer sub class'da belirli bir kurala göre eleman ekleme gerçekleştiriliyorsa ve alt sınıfta bu uygulanmışsa
     * sub class'da bu kuralın işletilmediği yeni bir method yazılırsa bu güvenlik sorununa neden olacaktır.
     *
     */
    public boolean add(E e){
        addCount++;
        return super.add(e);
    }

    /**
     * We could “fix” the subclass by eliminating its override of the addAll method.
     * While the resulting class would work, it would depend for its proper function on
     * the fact that HashSet’s addAll method is implemented on top of its add method.
     * This “self-use” is an implementation detail, not guaranteed to hold in all implementations
     * of the Java platform and subject to change from release to release.
     * Therefore, the resulting InstrumentedHashSet class would be fragile.
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount+=c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }
}
