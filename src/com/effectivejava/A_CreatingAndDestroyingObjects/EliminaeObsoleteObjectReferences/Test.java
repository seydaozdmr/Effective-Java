package com.effectivejava.A_CreatingAndDestroyingObjects.EliminaeObsoleteObjectReferences;

public class Test {
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(new String("merhaba"));
        myStack.push(new String("dünya"));

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
