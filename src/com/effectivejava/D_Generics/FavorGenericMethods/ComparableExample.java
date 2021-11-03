package com.effectivejava.D_Generics.FavorGenericMethods;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ComparableExample {

    /**
     * In summary, generic methods, like generic types, are safer and easier to use
     * than methods requiring their clients to put explicit casts on input parameters and
     * return values. Like types, you should make sure that your methods can be used
     * without casts, which often means making them generic. And like types, you
     * should generify existing methods whose use requires casts. This makes life easier
     * for new users without breaking existing clients (Item 26).
     */
    public static <E extends Comparable<E>> E max(Collection<E> c){
        return c.stream().max(new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.compareTo(o2);
            }
        }).get();
    }

    public static <E extends Comparable<E>> E max2(Collection<E> c){
        return c.stream().max((o1, o2) -> o1.compareTo(o2)).get();
    }

    public static <E extends Comparable<E>> E max3(Collection<E> c){
        return c.stream().max(Comparable::compareTo).get();
    }

    /**
     * public static <T extends Comparable<? super T>> T max(List<? extends T> list)
     * To get the revised declaration from the original, we applied the PECS heuristic
     * twice. The straightforward application is to the parameter list. It produces T
     * instances, so we change the type from List<T> to List<? extends T>. The tricky
     * application is to the type parameter T. This is the first time we’ve seen a wildcard
     * applied to a type parameter. Originally, T was specified to extend Comparable<T>,
     * but a comparable of T consumes T instances (and produces integers indicating
     * order relations). Therefore, the parameterized type Comparable<T> is replaced by
     * the bounded wildcard type Comparable<? super T>. Comparables are always
     * consumers, so you should generally use Comparable<? super T> in preference to
     * Comparable<T>. The same is true of comparators; therefore, you should generally
     * use Comparator<? super T> in preference to Comparator<T>.
     * @param args
     */

    public static void main(String[] args) {
        List<String> myList= List.of("Ankara","Izmir","Kaş");
        System.out.println(max(myList));

    }
}
