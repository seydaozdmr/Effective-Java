package com.effectivejava.D_Generics.DontUseRawTypes;

import java.util.HashSet;
import java.util.Set;

public class RawTypes {
    public static void main(String[] args) {
        Set set1=Set.of(1,2,3,4,5,6);
        Set set2=Set.of("bir","iki","üç","dört","beş");

        System.out.println(collectSets(set1,set2));

        System.out.println(countContains(set1,set2));

    }
    //bu method çalışır fakat interger set'i ile String set'ini contains ile karşılaştırmak yanlış bir uygulama olacaktır
    static int collectSets(Set set1,Set set2){
        int result = 0;
        for (Object o1 : set1)
            if (set2.contains(o1))
                result++;

        return result;
    }

    //bu durumu düzeltmek için Uses unbounded wildcard type - typesafe and flexible

    /**
     * What is the difference between the unbounded wildcard type Set<?> and the
     * raw type Set? Does the question mark really buy you anything? Not to belabor the
     * point, but the wildcard type is safe and the raw type isn’t. You can put any element
     * into a collection with a raw type, easily corrupting the collection’s type invariant
     * (as demonstrated by the unsafeAdd method on page 119); you can’t put any element
     * (other than null) into a Collection<?>.
     */
    static int countContains(Set<?> set1,Set<?> set2){
        int result = 0;
        for (Object o1 : set1)
            if (set2.contains(o1))
                result++;

        return result;
    }
}
