package com.effectivejava.C_ClassesAndInterfaces.PreferInterfacesToAbstractClasses;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class AdapterExample {

    public static void main(String[] args) {
        int [] dizi={1,2,3,4,5,6,7,8};

        List<Integer> myNumberList= intArrayAsList(dizi);
        myNumberList.forEach(System.out::println);
    }

    /**
     * The beauty of skeletal implementation classes is that they provide all of the
     * implementation assistance of abstract classes without imposing the severe constraints
     * that abstract classes impose when they serve as type definitions.
     */

    static List<Integer> intArrayAsList(int[] dizi){
        Objects.requireNonNull(dizi);

        /**
         * anonymous class :
         */
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return dizi[index];
            }

            @Override
            public int size() {
                return dizi.length;
            }

            @Override
            public Integer set(int index, Integer element) {
                int oldValue=dizi[index];
                dizi[index]= element;
                return oldValue;
            }
        };


    }
}
