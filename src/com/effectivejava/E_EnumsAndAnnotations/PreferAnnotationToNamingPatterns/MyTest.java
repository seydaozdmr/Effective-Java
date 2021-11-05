package com.effectivejava.E_EnumsAndAnnotations.PreferAnnotationToNamingPatterns;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyTest {
    /**
     * Annotations [JLS, 9.7] solve all of these problems nicely, and JUnit adopted
     * them starting with release 4. In this item, we’ll write our own toy testing framework
     * to show how annotations work. Suppose you want to define an annotation
     * type to designate simple tests that are run automatically and fail if they throw an
     * exception. Here’s how such an annotation type, named Test, might look:
     */

}
