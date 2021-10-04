package com.effectivejava.A_CreatingAndDestroyingObjects.EliminaeObsoleteObjectReferences;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack {
    private Object [] myStack;
    private int size=0;
    private static final int DEFAULT_INITIAL_CAPACITY=16;

    public MyStack() {
        myStack=new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o){
        ensureCapacity();
        myStack[size++]=o;
    }

    /***
     * The elements in the active portion of the
     * array (as defined earlier) are allocated, and those in the remainder of the array are
     * free. The garbage collector has no way of knowing this; to the garbage collector,
     * all of the object references in the elements array are equally valid. Only the
     * programmer knows that the inactive portion of the array is unimportant. The programmer
     * effectively communicates this fact to the garbage collector by manually
     * nulling out array elements as soon as they become part of the inactive portion.
     */
    public Object pop(){
        if(size==0){
            throw new EmptyStackException();
        }
        Object result=myStack[--size];
        myStack[size]=null;
        return result;
    }

    private void ensureCapacity(){
        if(size==myStack.length){
            myStack= Arrays.copyOf(myStack,2 * size +1);
        }
    }
}
