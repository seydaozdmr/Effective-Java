package com.effectivejava.D_Generics.UseBoundedWildcards;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

public class ComparableExample {
    public static void swap(List<?> list, int i, int j) {
        swapHelper(list,i,j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    /**
     * In summary, using wildcard types in your APIs, while tricky, makes the APIs
     * far more flexible. If you write a library that will be widely used, the proper use of
     * wildcard types should be considered mandatory. Remember the basic rule:
     * producer-extends, consumer-super (PECS). Also remember that all comparables
     * and comparators are consumers.
     */
}
