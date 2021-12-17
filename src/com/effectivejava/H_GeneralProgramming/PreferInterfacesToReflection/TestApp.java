package com.effectivejava.H_GeneralProgramming.PreferInterfacesToReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class TestApp {
    /**
     * Reflection allows one class to use another, even if the latter class did
     * not exist when the former was compiled. This power, however, comes at a price:
     * • You lose all the benefits of compile-time type checking, including exception
     * checking. If a program attempts to invoke a nonexistent or inaccessible method
     * reflectively, it will fail at runtime unless you’ve taken special precautions.
     * • The code required to perform reflective access is clumsy and verbose. It is
     * tedious to write and difficult to read.
     * • Performance suffers. Reflective method invocation is much slower than
     * normal method invocation. Exactly how much slower is hard to say, as there
     * are many factors at work. On my machine, invoking a method with no input
     * parameters and an int return was eleven times slower when done reflectively.
     */

    /**
     * You can obtain many of the benefits of reflection while incurring few of
     * its costs by using it only in a very limited form. For many programs that must
     * use a class that is unavailable at compile time, there exists at compile time an
     * appropriate interface or superclass by which to refer to the class (Item 64). If this
     * is the case, you can create instances reflectively and access them normally via
     * their interface or superclass.
     */

    /**
     * For example, here is a program that creates a Set<String> instance whose
     * class is specified by the first command line argument. The program inserts the
     * remaining command line arguments into the set and prints it. Regardless of the
     * first argument, the program prints the remaining arguments with duplicates
     * eliminated. The order in which these arguments are printed, however, depends on
     * the class specified in the first argument. If you specify java.util.HashSet,
     * they’re printed in apparently random order; if you specify java.util.TreeSet,
     * they’re printed in alphabetical order because the elements in a TreeSet are sorted:
     */
    public static void main(String[] args) {
        // Translate the class name into a Class object
        Class<? extends Set<String>> cl = null;
        try {
            cl = (Class<? extends Set<String>>) // Unchecked cast!
                    Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            fatalError("Class not found.");
        }
// Get the constructor
        Constructor<? extends Set<String>> cons = null;
        try {
            cons = cl.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fatalError("No parameterless constructor");
        }
// Instantiate the set
        Set<String> s = null;
        try {
            s = cons.newInstance();
        } catch (IllegalAccessException e) {
            fatalError("Constructor not accessible");
        } catch (InstantiationException e) {
            fatalError("Class not instantiable.");
        } catch (InvocationTargetException e) {
            fatalError("Constructor threw " + e.getCause());
        } catch (ClassCastException e) {
            fatalError("Class doesn't implement Set");
        }
// Exercise the set
        s.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(s);
    }
    private static void fatalError(String msg) {
        System.err.println(msg);
        System.exit(1);
    }
    /**
     * While this program is just a toy, the technique it demonstrates is quite
     * powerful. The toy program could easily be turned into a generic set tester that
     * validates the specified Set implementation by aggressively manipulating one or
     * more instances and checking that they obey the Set contract. Similarly, it could be
     * turned into a generic set performance analysis tool. In fact, this technique is
     * sufficiently powerful to implement a full-blown service provider framework
     * (Item 1). Usually, this technique is all that you need in the way of reflection.
     */
}
