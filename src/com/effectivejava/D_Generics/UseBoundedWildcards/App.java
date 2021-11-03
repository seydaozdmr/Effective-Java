package com.effectivejava.D_Generics.UseBoundedWildcards;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Stack<String> myStack=new Stack<>();
        myStack.push("Hasan");
        myStack.push("Hikmet");
        myStack.push("Kerim");

        List<String> myList=new ArrayList<>();
        myStack.popAll(myList);
        System.out.println(myList);
        System.out.println(myStack.isEmpty());
    }
}
