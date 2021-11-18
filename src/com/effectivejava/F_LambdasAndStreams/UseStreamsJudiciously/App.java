package com.effectivejava.F_LambdasAndStreams.UseStreamsJudiciously;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class App {
    /**
     * The streams API was added in Java 8 to ease the task of performing bulk operations,
     * sequentially or in parallel. This API provides two key abstractions: the stream,
     * which represents a finite or infinite sequence of data elements, and the stream pipeline,
     * which represents a multistage computation on these elements. The elements in
     * a stream can come from anywhere. Common sources include collections, arrays,
     * files, regular expression pattern matchers, pseudorandom number generators, and
     * other streams. The data elements in a stream can be object references or primitive
     * values. Three primitive types are supported: int, long, and double.
     */

    /**
     * The streams API is sufficiently versatile that practically any computation can
     * be performed using streams, but just because you can doesn’t mean you should.
     * When used appropriately, streams can make programs shorter and clearer; when
     * used inappropriately, they can make programs difficult to read and maintain. There
     * are no hard and fast rules for when to use streams, but there are heuristics.
     */
    public static void main(String[] args) {

    }

    /**
     * The program reads each word from a user-specified dictionary file and
     * places the words into a map. The map key is the word with its letters alphabetized,
     * so the key for "staple" is "aelpst", and the key for "petals" is also "aelpst":
     * the two words are anagrams, and all anagrams share the same alphabetized form
     * (or alphagram, as it is sometimes known). The map value is a list containing all of
     * the words that share an alphabetized form. After the dictionary has been processed,
     * each list is a complete anagram group. The program then iterates through
     * the map’s values() view and prints each list whose size meets the threshold:
     */

    private static void printAnagrams(String[] args) throws FileNotFoundException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);
        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }
        }
        for (Set<String> group : groups.values())
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
    }

    /**
     * Using helper methods is
     * even more important for readability in stream pipelines than in iterative code
     * because pipelines lack explicit type information and named temporary variables.
     */
    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    /**
     *  Luckily, there is a happy medium. The following program solves the same
     *     problem, using streams without overusing them. The result is a program that’s
     *     both shorter and clearer than the original:
     */

    // Tasteful use of streams enhances clarity and conciseness
    public static void printAnagramsWithStreams(String[] args) throws IOException {
            Path dictionary = Paths.get(args[0]);
            int minGroupSize = Integer.parseInt(args[1]);
            try (Stream<String> words = Files.lines(dictionary)) {
                words.collect(groupingBy(App::alphabetize))
                        .values().stream()
                        .filter(group -> group.size() >= minGroupSize)
                        .forEach(g -> System.out.println(g.size() + ": " + g));
            }
        }// alphabetize method is the same as in original version

    /**
     * As shown in the programs in this item, stream pipelines express repeated computation
     * using function objects (typically lambdas or method references), while
     * iterative code expresses repeated computation using code blocks. There are some
     * things you can do from code blocks that you can’t do from function objects:
     * • From a code block, you can read or modify any local variable in scope; from a
     * lambda, you can only read final or effectively final variables [JLS 4.12.4], and
     * you can’t modify any local variables.
     * • From a code block, you can return from the enclosing method, break or
     * continue an enclosing loop, or throw any checked exception that this method
     * is declared to throw; from a lambda you can do none of these things.
     */
}
