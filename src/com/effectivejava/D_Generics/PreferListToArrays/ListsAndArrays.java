package com.effectivejava.D_Generics.PreferListToArrays;

import java.util.ArrayList;
import java.util.List;

public class ListsAndArrays {
    public static void main(String[] args) {
        Object [] myArray=new Long[10];
        myArray[0]="this some mistake";

        //this never compile incompatible types
        //List<Object> myList =new ArrayList<Long>();

        /**
         * Either way you can’t put a String into a Long container, but with an array you
         * find out that you’ve made a mistake at runtime; with a list, you find out at compile
         * time. Of course, you’d rather find out at compile time.
         * The second major difference between arrays and generics is that arrays are
         * reified [JLS, 4.7]. This means that arrays know and enforce their element type at
         * runtime. As noted earlier, if you try to put a String into an array of Long, you’ll
         * get an ArrayStoreException.
         */

        //List<String>[] stringLists = new List<String>[1]; // (1)
//        List<Integer> intList = List.of(42); // (2)
//        Object[] objects = stringLists; // (3)
//        objects[0] = intList; // (4)
//        String s = stringLists[0].get(0); // (5)

    }
}
