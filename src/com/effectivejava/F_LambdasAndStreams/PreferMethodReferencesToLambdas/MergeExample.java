package com.effectivejava.F_LambdasAndStreams.PreferMethodReferencesToLambdas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MergeExample {
    public static void main(String[] args) {
        Map<List<String>,Integer> map=new HashMap<>();
        List<String> myList = List.of("Ankara","İzmir");
        /**
         * The more parameters a method has, the more boilerplate you can eliminate with a
         * method reference. In some lambdas, however, the parameter names you choose
         * provide useful documentation, making the lambda more readable and maintainable
         * than a method reference, even if the lambda is longer.
         */
        map.merge(myList,1,Integer::sum);

        System.out.println(map);
        /**
         * In summary, method references often provide a more succinct alternative to
         * lambdas. Where method references are shorter and clearer, use them; where
         * they aren’t, stick with lambdas.
         */
    }
}
