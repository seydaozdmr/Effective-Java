package com.effectivejava.F_LambdasAndStreams.PreferLambdasToAnonymousClasses;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparisonExample {


    public static void main(String[] args) {
        List<String> words = List.of("kalem","kağıt","defter","masa");
        /**
         * Anonymous classes were adequate for the classic objected-oriented design
         * patterns requiring function objects, notably the Strategy pattern [Gamma95]. The
         * Comparator interface represents an abstract strategy for sorting; the anonymous
         * class above is a concrete strategy for sorting strings. The verbosity of anonymous
         * classes, however, made functional programming in Java an unappealing prospect.
         */
        Collections.sort(words,new Comparator<String>(){
            public int compare(String s1,String s2){
                return Integer.compare(s1.length(),s2.length());
            }
        });

        /**
         * Anonymous classes were adequate for the classic objected-oriented design
         * patterns requiring function objects, notably the Strategy pattern [Gamma95]. The
         * Comparator interface represents an abstract strategy for sorting; the anonymous
         * class above is a concrete strategy for sorting strings. The verbosity of anonymous
         * classes, however, made functional programming in Java an unappealing prospect.
         */
        Collections.sort(words,(s1,s2)->Integer.compare(s1.length(),s2.length()));
        /**
         * Omit the types of all lambda parameters unless their presence makes your program clearer.
         *
         */

        /**
         * One caveat should be added concerning type inference. Item 26 tells you not
         * to use raw types, Item 29 tells you to favor generic types, and Item 30 tells you to
         * favor generic methods. This advice is doubly important when you’re using
         * lambdas, because the compiler obtains most of the type information that allows it
         * to perform type inference from generics. If you don’t provide this information, the
         * compiler will be unable to do type inference, and you’ll have to specify types
         * manually in your lambdas, which will greatly increase their verbosity.
         */

        /**
         * Incidentally, the comparator in the snippet can be made even more succinct if
         * a comparator construction method is used in place of a lambda (Items 14. 43):
         */
        Collections.sort(words, Comparator.comparingInt(String::length));

        /**
         * In fact, the snippet can be made still shorter by taking advantage of the sort
         * method that was added to the List interface in Java 8:
         */

        words.sort(Comparator.comparingInt(String::length));
    }
}
