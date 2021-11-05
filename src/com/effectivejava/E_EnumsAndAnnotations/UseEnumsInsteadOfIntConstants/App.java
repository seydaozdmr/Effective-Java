package com.effectivejava.E_EnumsAndAnnotations.UseEnumsInsteadOfIntConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<Apple> myEnums= new ArrayList<>(List.of(Apple.FUJI, Apple.GRANNY_SMITH, Apple.PIPPIN));

        /**
         * The basic idea behind Java’s enum types is simple: they are classes that export
         * one instance for each enumeration constant via a public static final field. Enum
         * types are effectively final, by virtue of having no accessible constructors. Because
         * clients can neither create instances of an enum type nor extend it, there can be no
         * instances but the declared enum constants. In other words, enum types are
         * instance-controlled (page 6). They are a generalization of singletons (Item 3),
         * which are essentially single-element enums.
         */
        for(Apple apple:myEnums){
            System.out.println(apple.getId());
            System.out.println(apple);
        }

        /**
         * In addition to rectifying the deficiencies of int enums, enum types let you add
         * arbitrary methods and fields and implement arbitrary interfaces. They provide
         * high-quality implementations of all the Object methods (Chapter 3), they implement
         * Comparable (Item 14) and Serializable (Chapter 12), and their serialized
         * form is designed to withstand most changes to the enum type.
         */
        System.out.println("Compared");
        Collections.sort(myEnums);
        for(Apple apple:myEnums){
            System.out.println(apple.getId());
            System.out.println(apple);
        }

        var myMap=stringToEnum;
        for(var elem:stringToEnum.entrySet()){
            System.out.println(elem.getKey()+ " " +elem.getValue());
        }
    }

    private static final Map<String, EnhancedOperation> stringToEnum =
            Stream.of(EnhancedOperation.values()).collect(
                    Collectors.toMap(Object::toString, e -> e));
}
