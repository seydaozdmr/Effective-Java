package com.effectivejava.C_ClassesAndInterfaces.MinimizeAccessibilityOfClassesandMembers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class School {
    /**
     * The single most important factor that distinguishes a well-designed component
     * from a poorly designed one is the degree to which the component hides its internal
     * data and other implementation details from other components. A well-designed
     * component hides all its implementation details, cleanly separating its API from its
     * implementation. Components then communicate only through their APIs and are
     * oblivious to each others’ inner workings. This concept, known as information
     * hiding or encapsulation, is a fundamental tenet of software design [Parnas72].
     */
    //you should private access modifier to mutable fields.
    private String name;
    private String location;

    //you can public for final constants
    public static final int SCHOOL_ID=973365;

    /**
     * Note that a nonzero-length array is always mutable, so it is wrong for a class
     * to have a public static final array field, or an accessor that returns such a
     * field. If a class has such a field or accessor, clients will be able to modify the contents
     * of the array. This is a frequent source of security holes:
     */
    public static final String [] classes = {"1A","2A","3A","4A"};
    /**
     * There are two ways to fix the
     * problem. You can make the public array private and add a public immutable list:
     */
    private static final String [] FLOORS = {"1","2","3"};
    private static final List<String> BUILDINGS = Collections.unmodifiableList(Arrays.asList("ANA BİNA","B BLOK"));

    /**
     * Alternatively, you can make the array private and add a public method that
     * returns a copy of a private array:
     */

    private static final String [] GARDENS = {"ANA BAHÇE","ARKA BAHÇE"};
    public static final String [] values(){
        return GARDENS.clone();
    }


    /**
     * After carefully designing a minimal public API, you
     * should prevent any stray classes, interfaces, or members from becoming part of
     * the API. With the exception of public static final fields, which serve as constants,
     * public classes should have no public fields. Ensure that objects referenced by
     * public static final fields are immutable.
     */

}
