package com.effectivejava.F_LambdasAndStreams.PreferSideEffectFreeFunctions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class App {
    /**
     * The most important part of the streams paradigm is to structure your computation
     * as a sequence of transformations where the result of each stage is as close as
     * possible to a pure function of the result of the previous stage. A pure function is
     * one whose result depends only on its input: it does not depend on any mutable
     * state, nor does it update any state. In order to achieve this, any function objects
     * that you pass into stream operations, both intermediate and terminal, should be
     * free of side-effects.
     */

    /**
     * The most important part of the streams paradigm is to structure your computation
     * as a sequence of transformations where the result of each stage is as close as
     * possible to a pure function of the result of the previous stage. A pure function is
     * one whose result depends only on its input: it does not depend on any mutable
     * state, nor does it update any state. In order to achieve this, any function objects
     * that you pass into stream operations, both intermediate and terminal, should be
     * free of side-effects.
     * Occasionally, you may see streams code that looks like this snippet, which
     * builds a frequency table of the words in a text file:
     *
     */

    public static void main(String[] args) throws FileNotFoundException {
        // Uses the streams API but not the paradigm--Don't do this!
        Map<String, Long> freq = new HashMap<>();
        try (Stream<String> words = new Scanner(new File("test.txt")).tokens()) {
            /**
             * The forEach operation should be used only to report the result of a
             * stream computation, not to perform the computation.
             */
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        }

        /**
         * What’s wrong with this code? After all, it uses streams, lambdas, and method
         * references, and gets the right answer. Simply put, it’s not streams code at all; it’s
         * iterative code masquerading as streams code. It derives no benefits from the
         * streams API, and it’s (a bit) longer, harder to read, and less maintainable than the
         * corresponding iterative code. The problem stems from the fact that this code is
         * doing all its work in a terminal forEach operation, using a lambda that mutates
         * external state (the frequency table). A forEach operation that does anything more
         * than present the result of the computation performed by a stream is a “bad smell in
         * code,” as is a lambda that mutates state. So how should this code look?
         */

        // Proper use of streams to initialize a frequency table
        Map<String, Long> freq2;
//        try (Stream<String> words = new Scanner(new File("test.txt")).tokens()) {
//            freq2 = words
//                    .collect(Collectors.groupingBy(String::toLowerCase, counting()));
//        }
        /**
         * This snippet does the same thing as the previous one but makes proper use of
         * the streams API. It’s shorter and clearer. So why would anyone write it the other
         * way? Because it uses tools they’re already familiar with. Java programmers know
         * how to use for-each loops, and the forEach terminal operation is similar. But the
         * forEach operation is among the least powerful of the terminal operations and the
         * least stream-friendly. It’s explicitly iterative, and hence not amenable to parallelization.
         * The forEach operation should be used only to report the result of a
         * stream computation, not to perform the computation. Occasionally, it makes
         * sense to use forEach for some other purpose, such as adding the results of a
         * stream computation to a preexisting collection.
         */

        /**
         * The collectors for gathering the elements of a stream into a true Collection
         * are straightforward. There are three such collectors: toList(), toSet(), and
         * toCollection(collectionFactory). They return, respectively, a set, a list, and
         * a programmer-specified collection type. Armed with this knowledge, we can write
         * a stream pipeline to extract a top-ten list from our frequency table.
         */

        // Pipeline to get a top-ten list of words from a frequency table
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());

        System.out.println(topTen);
        /**
         * Note that we haven’t qualified the toList method with its class, Collectors. It is
         * customary and wise to statically import all members of Collectors because
         * it makes stream pipelines more readable.
         */
    }


}
