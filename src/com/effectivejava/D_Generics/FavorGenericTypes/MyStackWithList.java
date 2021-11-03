package com.effectivejava.D_Generics.FavorGenericTypes;

import java.util.ArrayList;
import java.util.List;

public class MyStackWithList <E>{
    private List<E> elements;
    private static final int DEFAULT_INITIAL_CAPACITY = 20;
    private int size=0;

    public MyStackWithList() {
        elements=new ArrayList<>(DEFAULT_INITIAL_CAPACITY);
    }
}
