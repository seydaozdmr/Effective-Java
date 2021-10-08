package com.effectivejava.B_MethodsCommontoAllObjects.AlwaysOverrideToString;

public class App {
    public static void main(String[] args) {

        /**
         * To recap, override Object’s toString implementation in every instantiable
         * class you write, unless a superclass has already done so. It makes classes much
         * more pleasant to use and aids in debugging. The toString method should return a
         * concise, useful description of the object, in an aesthetically pleasing format.
         */

        Car araba=new Car(1,"Mazda");
        System.out.println(araba);

    }
}
