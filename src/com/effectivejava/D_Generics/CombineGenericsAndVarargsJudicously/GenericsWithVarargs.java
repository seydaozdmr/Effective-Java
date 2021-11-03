package com.effectivejava.D_Generics.CombineGenericsAndVarargsJudicously;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenericsWithVarargs {
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // Heap pollution
        String s = stringLists[0].get(0); // ClassCastException
    }

    public static void main(String[] args) {
        List<String> myList= List.of("Ankara","İstanbul");
        //dangerous(myList); //result .ClassCastException

        //String[] attributes = pickTwo("Good", "Fast", "Cheap");
        //System.out.println(attributes);

        List<String> myList2= List.of("İzmir","Antalya");
        List<String> union=flatten(myList,myList2);
        System.out.println(union);
    }


    //T tipindeki varargs'ı T tipinde (T[]) bir array olarak geri dönen method.
    static <T> T[] toArray(T... args) {
        //bunun sonucunda .ClassCastException ortaya çıkar
        //[Ljava.lang.Object; cannot be cast to class [Ljava.lang.String;
        //Object[] dizisi String[] tipine cast edilemez bundan dolayı hata verir.
        T[] dizi = (T[]) new Object[args.length];
        for(int i=0;i< args.length;i++){
            dizi[i]=args[i];
        }
        return dizi;
    }

    /**
     * it is safe to pass the array to another varargs method that is correctly annotated
     * with @SafeVarargs, and it is safe to pass the array to a non-varargs method
     * that merely computes some function of the contents of the array.
     */
    static <T> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }


    /**
     * Here is a typical example of a safe use of a generic varargs parameter. This
     * method takes an arbitrary number of lists as arguments and returns a single list
     * containing the elements of all of the input lists in sequence. Because the method is
     * annotated with @SafeVarargs, it doesn’t generate any warnings, on the declaration
     * or at its call sites:
     */
    static <T> List<T> flatten(List<? extends  T> ...args) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> elem : args) {
            result.addAll(elem);
        }
        return result;
    }

        /**
         * As a reminder, a generic varargs methods is safe if:
         * 1. it doesn’t store anything in the varargs parameter array, and
         * 2. it doesn’t make the array (or a clone) visible to untrusted code.
         */

        /**An alternative to using the SafeVarargs annotation is to take the advice of
    Item 28 and replace the varargs parameter (which is an array in disguise) with a
    List parameter. Here’s how this approach looks when applied to our flatten
    method. Note that only the parameter declaration has changed:
    // List as a typesafe alternative to a generic varargs parameter
         */
    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }

    }
