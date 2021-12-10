package com.effectivejava.G_Methods.UseVarargsJudiciously;

public class VarargsExample {
    public static void main(String[] args) {
        /**
         *  For example, here is a varargs method that takes a sequence of int arguments
         *         and returns their sum. As you would expect, the value of sum(1, 2, 3) is 6, and
         *         the value of sum() is 0:
         */
        System.out.println(sum(1,2,3,4,5,6,7));

        }

    // Simple use of varargs
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args)
            sum += arg;
        return sum;
    }

    /**
     * Sometimes it’s appropriate to write a method that requires one or more arguments
     * of some type, rather than zero or more. For example, suppose you want to
     * write a function that computes the minimum of its arguments. This function is not
     * well defined if the client passes no arguments. You could check the array length at
     * runtime:
     */

    // The WRONG way to use varargs to pass one or more arguments!
    static int min(int... args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Too few arguments");
        int min = args[0];
        for (int i = 1; i < args.length; i++)
            if (args[i] < min)
                min = args[i];
        return min;
    }
    /**
     * This solution has several problems. The most serious is that if the client
     * invokes this method with no arguments, it fails at runtime rather than compile
     * time. Another problem is that it is ugly.This solution corrects all the deficiencies of the
     * previous one:
     */

    // The right way to use varargs to pass one or more arguments
    static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }
    /**
     * The static factories for EnumSet use this technique to reduce the cost of creating
     * enum sets to a minimum. This was appropriate because it was critical that
     * enum sets provide a performance-competitive replacement for bit fields (Item 36).
     * In summary, varargs are invaluable when you need to define methods with a
     * variable number of arguments. Precede the varargs parameter with any required
     * parameters, and be aware of the performance consequences of using varargs.
     */
}
