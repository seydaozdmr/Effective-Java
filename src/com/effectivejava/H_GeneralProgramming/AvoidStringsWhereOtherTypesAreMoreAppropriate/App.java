package com.effectivejava.H_GeneralProgramming.AvoidStringsWhereOtherTypesAreMoreAppropriate;

public class App {
    /**
     * Strings are poor substitutes for enum types. As discussed in Item 34,
     * enums make far better enumerated type constants than strings.
     * Strings are poor substitutes for aggregate types. If an entity has multiple
     * components, it is usually a bad idea to represent it as a single string. For example,
     * here’s a line of code that comes from a real system—identifier names have been
     * changed to protect the guilty:
     * // Inappropriate use of string as aggregate type
     *
     */ //String compoundKey = className + "#" + i.next();

     /** This approach has many disadvantages. If the character used to separate fields
     * occurs in one of the fields, chaos may result. To access individual fields, you have
     * to parse the string, which is slow, tedious, and error-prone. You can’t provide
     * equals, toString, or compareTo methods but are forced to accept the behavior
     * that String provides. A better approach is simply to write a class to represent the
     * aggregate, often a private static member class (Item 24).
     * Strings are poor substitutes for capabilities. Occasionally, strings are used
     * to grant access to some functionality. For example, consider the design of a
     * thread-local variable facility. Such a facility provides variables for which each
     * thread has its own value. The Java libraries have had a thread-local variable facility
     * since release 1.2, but prior to that, programmers had to roll their own. When
     * confronted with the task of designing such a facility many years ago, several
      * people independently came up with the same design, in which client-provided
      * string keys are used to identify each thread-local variable:
     */


}
class ThreadLocal{
    private static String name;
    private ThreadLocal() { } // Noninstantiable

    // Sets the current thread's value for the named variable.
    public static void set(String key, Object value){
        name+=key + " "+value.toString();
    }

    // Returns the current thread's value for the named variable.
    public static Object get(String key){
        return name;
    }
}

class ThreadLocal2 {
    private ThreadLocal2() { } // Noninstantiable
    public static class Key { // (Capability)
        Key() { }
    }
    // Generates a unique, unforgeable key
    public static Key getKey() {
        return new Key();
    }
    //public static void set(Key key, Object value);
    //public static Object get(Key key);
}

/**
 * To summarize, avoid the natural tendency to represent objects as strings when
 * better data types exist or can be written. Used inappropriately, strings are more
 * cumbersome, less flexible, slower, and more error-prone than other types. Types
 * for which strings are commonly misused include primitive types, enums, and
 * aggregate types.
 */
