package com.effectivejava.J_Concurrency.AvoidExcessiveSynchronization;

import com.effectivejava.C_ClassesAndInterfaces.FavorCompositionOverInheritance.ForwardingSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ObservableSet <E> extends ForwardingSet<E> {
    /**
     * ObserveableSet sınıfı içerisinde ForwardingSet'ten miras aldığı bir Set<E> Collection'ı tutar.
     * @param mySet is a interface collection
     */

    public ObservableSet(Set<E> mySet) {
        super(mySet);
    }

    /**
     * ObservableSet sınıfı içerisinde SetObserver<E> interface'ini alan bir adet liste tutar bu sınıfın
     * gözlemcileridir. Gözlemciler listeye eklenir ya da listeden çıkartılır.
     */
    private final List<SetObserver<E>> observers
            = new ArrayList<>();

    //gözlemci eklemek için kullanırız.
    public void addObserver(SetObserver<E> observer) {
        synchronized(observers) {
            //burada bir method ekliyoruz soyut bir yapı bu yapıyı daha sonra lambda içinden çalıştırıyoruz
            observers.add(observer);
        }
    }
    //gözlemci silmek için kullanırız.
    public boolean removeObserver(SetObserver<E> observer) {
        synchronized(observers) {
            return observers.remove(observer);
        }
    }
    //Bu nesneyi takip eden her bir gözlemciye eklenen elemanı gönderiyor
    private void notifyElementAdded(E element) {
        synchronized(observers) {
            for (SetObserver<E> observer : observers)
                //gözlenen olarak her zaman kendisini verir.
                //observers'a eklediğimiz somut hale getirilmiş gözlemciye
                //messages.addObserver((a,b)->System.out.println("Birinci Gözlemci = "+b));
                //aşağıdaki parametreleri gönderiyoruz. Bu nesneyi takip ediyorsun ve buna element elemanı eklendi
                //şeklinde.
                observer.added(this, element);


        }
    }
    //eleman set 'e ekleniyor bununla birlikte bu nesneyi takip eden gözlemcilere bunun eklendiğini bildiriyor.
    @Override public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            //yukarıda tanımlanan notifyElementAdded methodu çağrılır.
            notifyElementAdded(element);
        return added;
    }
    @Override public boolean addAll (Collection<? extends E> c) {
        boolean result = false;
        for (E element : c)
            result |= add(element); // Calls notifyElementAdded
        return result;
    }

    public void getObserver(){
        for(SetObserver<E> elem:observers){
            System.out.println(elem);
        }
    }


}

/**
 *
 */
