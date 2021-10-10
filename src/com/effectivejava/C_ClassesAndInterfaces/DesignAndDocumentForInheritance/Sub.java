package com.effectivejava.C_ClassesAndInterfaces.DesignAndDocumentForInheritance;

import java.time.Instant;

public final class Sub extends Super {

    private final Instant instant;

    /**
     * Note that it is safe to invoke private methods, final methods, and static methods,
     * none of which are overridable, from a constructor.
     */
    Sub() {
        instant = Instant.now();
    }

    /**
     * Here’s a subclass that overrides the overrideMe method, which is erroneously
     * invoked by Super’s sole constructor:
     */
    @Override
    public void overrideMe() {
        System.out.println(instant);
        /**
         * You can eliminate a class’s self-use of overridable methods mechanically,
         * without changing its behavior. Move the body of each overridable method to a
         * private “helper method” and have each overridable method invoke its private
         * helper method. Then replace each self-use of an overridable method with a direct
         * invocation of the overridable method’s private helper method.
         */
    }

    public static void main(String[] args) {

        /**
         * This advice may be somewhat controversial because many programmers have
         * grown accustomed to subclassing ordinary concrete classes to add facilities such
         * as instrumentation, notification, and synchronization or to limit functionality. If a
         * class implements some interface that captures its essence, such as Set, List, or
         * Map, then you should feel no compunction about prohibiting subclassing. The
         * wrapper class pattern, described in Item 18, provides a superior alternative to
         * inheritance for augmenting the functionality.
         */
        Sub sub = new Sub();
        sub.overrideMe();
    }
}