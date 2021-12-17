package com.effectivejava.H_GeneralProgramming.BewarePerformansOfStringConcatenation;

public class ConcatenatingExample {
    /**
     * Using the string
     * concatenation operator repeatedly to concatenate n strings requires time quadratic
     * in n. This is an unfortunate consequence of the fact that strings are immutable
     * (Item 17). When two strings are concatenated, the contents of both are copied.
     * For example, consider this method, which constructs the string representation
     * of a billing statement by repeatedly concatenating a line for each item:
     * // Inappropriate use of string concatenation - Performs poorly!
     public String statement() {
     * String result = "";
     * for (int i = 0; i < numItems(); i++)
     * result += lineForItem(i); // String concatenation
     * return result;
     * }
     * The method performs abysmally if the number of items is large. To achieve
     * acceptable performance, use a StringBuilder in place of a String to store the
     * statement under construction:
     * public String statement() {
     * StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);
     * for (int i = 0; i < numItems(); i++)
     * b.append(lineForItem(i));
     * return b.toString();
     * }
     * A lot of work has gone into making string concatenation faster since Java 6,
     * but the difference in the performance of the two methods is still dramatic: If
     * numItems returns 100 and lineForItem returns an 80-character string, the second
     * method runs 6.5 times faster than the first on my machine.
     */
}
