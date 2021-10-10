package com.effectivejava.C_ClassesAndInterfaces.FavorCompositionOverInheritance;

import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        /**
         * The InstrumentedSet class is known as a wrapper class because each
         * InstrumentedSet instance contains (“wraps”) another Set instance. This is also
         * known as the Decorator pattern [Gamma95] because the InstrumentedSet class
         * “decorates” a set by adding instrumentation.
         */
        /**
         * To summarize, inheritance is powerful, but it is problematic because it
         * violates encapsulation. It is appropriate only when a genuine subtype relationship
         * exists between the subclass and the superclass. Even then, inheritance may lead to
         * fragility if the subclass is in a different package from the superclass and the
         * superclass is not designed for inheritance. To avoid this fragility, use composition
         * and forwarding instead of inheritance, especially if an appropriate interface to
         * implement a wrapper class exists. Not only are wrapper classes more robust than
         * subclasses, they are also more powerful.
         */
        Set<String> cities= new InstrumentedSet<>(new HashSet<>());

        cities.add("Antalya");
        cities.add("İzmir");
        cities.add("İstanbul");

        System.out.println(cities);

    }
}
