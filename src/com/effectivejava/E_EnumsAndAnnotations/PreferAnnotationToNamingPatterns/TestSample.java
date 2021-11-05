package com.effectivejava.E_EnumsAndAnnotations.PreferAnnotationToNamingPatterns;

public class TestSample {
    @MyTest
    public static void m1() {}

    public static void m2() { }

    @MyTest
    public static void m3() { // Test should fail
        throw new RuntimeException("Boom");
    }
    public static void m4() { }

    @MyTest
    public void m5() { } // INVALID USE: nonstatic method

    public static void m6() { }

    @MyTest public static void m7() { // Test should fail
        throw new RuntimeException("Crash");
    }

    public static void m8() { }
}
