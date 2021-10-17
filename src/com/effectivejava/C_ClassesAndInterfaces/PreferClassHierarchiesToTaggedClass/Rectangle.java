package com.effectivejava.C_ClassesAndInterfaces.PreferClassHierarchiesToTaggedClass;

public class Rectangle implements Figure{
    private final int a;
    private final int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a*b;
    }
}
