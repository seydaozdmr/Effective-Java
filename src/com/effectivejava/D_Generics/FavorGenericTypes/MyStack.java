package com.effectivejava.D_Generics.FavorGenericTypes;

import java.util.EmptyStackException;

// Initial attempt to generify Stack - won't compile!
public class MyStack <E>{
    private static final int DEFAULT_INITIAL_CAPACITY = 20;
    private E[] elements;
    private int size=0;

    @SuppressWarnings("unchecked") //type safety uyarısını bastırıyoruz
    public MyStack() {
        /**
         * As explained in Item 28, you can’t create an array of a non-reifiable type, such
         * as E.
         */
        //this.elements = new E[DEFAULT_INITIAL_CAPACITY];

        /**
         * The first solution directly circumvents
         * the prohibition on generic array creation: create an array of Object and cast
         * it to the generic array type. Now in place of an error, the compiler will emit a
         * warning. This usage is legal, but it’s not (in general) typesafe:
         */
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];

    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
// push requires elements to be of type E, so cast is correct
        //eğer element'i Object[] şeklinde değiştirirsek elemanları çıkarırken cast etmemiz gerekecektir.
        @SuppressWarnings("unchecked") E result =
                (E) elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }


}
