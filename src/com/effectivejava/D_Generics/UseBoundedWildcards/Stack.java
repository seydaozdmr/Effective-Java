package com.effectivejava.D_Generics.UseBoundedWildcards;

import java.util.Collection;

public class Stack<T> {
    private T [] myArray ;
    private final int INITIAL_CAPACITY =10;
    private int size;

    public Stack() {
        myArray= (T[]) new Object[INITIAL_CAPACITY];
        size=0;
    }

    public void push(T t){
        myArray[size++]=t;
    }

    public T pop(){
        if(size==0){
            throw new UnsupportedOperationException();
        }
        return myArray[--size];
    }

    public boolean isEmpty(){
        return size==0;
    }

    // pushAll method without wildcard type - deficient!
    public void pushAll(Iterable<T> elems){
        for(T e:elems){
            push(e);
        }
    }

    /**
     * This method compiles cleanly, but it isn’t entirely satisfactory. If the element type
     * of the Iterable src exactly matches that of the stack, it works fine. But suppose
     * you have a Stack<Number> and you invoke push(intVal), where intVal is of
     * type Integer. This works because Integer is a subtype of Number. So logically, it
     * seems that this should work, too:
     */


    /**
     * Luckily, there’s a way out. The language provides a special kind of parameterized
     * type call a bounded wildcard type to deal with situations like this. The type of
     * the input parameter to pushAll should not be “Iterable of E” but “Iterable of
     * some subtype of E,” and there is a wildcard type that means precisely that: Iterable<?
     * extends E>. (The use of the keyword extends is slightly misleading:
     * recall from Item 29 that subtype is defined so that every type is a subtype of itself,
     * even though it does not extend itself.) Let’s modify pushAll to use this type:
     */

    // Wildcard type for a parameter that serves as an E producer
    public void pushAllWithWildcard(Iterable<? extends T> src) {
        for (T e : src)
            push(e);
    }

    /**
     * The type of the input parameter to popAll should not be “collection of E” but
     * “collection of some supertype of E”
     * (where supertype is defined such that E is a supertype of itself [JLS, 4.10]). Again,
     * there is a wildcard type that means precisely that: Collection<? super E>. Let’s
     * modify popAll to use it:
     */

    // Wildcard type for parameter that serves as an E consumer

    /**
     * The lesson is clear. For maximum flexibility, use wildcard types on input
     * parameters that represent producers or consumers.
     */
    public void popAll(Collection<? super T> dst) {
        while (!isEmpty())
            dst.add(pop());
    }
    /**
     * Where exactly use <? extends E> and <? super T> ?
     * In other words, if a parameterized type represents a T producer, use <? extends T>;
     * if it represents a T consumer, use <? super T>. In our Stack example, pushAll’s
     * src parameter produces E instances for use by the Stack, so the appropriate type
     * for src is Iterable<? extends E>; popAll’s dst parameter consumes E instances
     * from the Stack, so the appropriate type for dst is Collection<? super E>. The
     * PECS mnemonic captures the fundamental principle that guides the use of wildcard
     * types. Naftalin and Wadler call it the Get and Put Principle [Naftalin07, 2.4].
     */

    /**
     * // Wildcard type for parameter that serves as an T producer
     * public Chooser(Collection<? extends T> choices)
     * bu şekilde kullanırsak Chooser<Number> sınıfının constructor'ına List<Integer> gönderebiliriz.
     */

}
