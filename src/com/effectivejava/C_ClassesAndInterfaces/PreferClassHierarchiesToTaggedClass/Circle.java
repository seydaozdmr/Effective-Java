package com.effectivejava.C_ClassesAndInterfaces.PreferClassHierarchiesToTaggedClass;

public class Circle implements Figure{
    /**
     * There is a separate data type associated
     * with each flavor, allowing programmers to indicate the flavor of a variable
     * and to restrict variables and input parameters to a particular flavor.
     */
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * 3.14;
    }
}
