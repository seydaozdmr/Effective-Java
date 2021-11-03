package com.effectivejava.D_Generics.FavorGenericMethods;

import java.util.HashSet;
import java.util.Set;

public class SetUnion {

    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    /**
     * A limitation of the union method is that the types of all three sets (both input
     * parameters and the return value) have to be exactly the same. You can make the
     * method more flexible by using bounded wildcard types (Item 31).
     */
    public static <E> Set<E> union2(Set<E> set1,Set<E> set2){
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }


}
