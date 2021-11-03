package com.effectivejava.D_Generics.FavorGenericMethods;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    private static UnaryOperator<Object> IDENTITY_FN= (e) -> e;

    public static <T> UnaryOperator<T> identityFunction ()  {
        return (UnaryOperator<T>) IDENTITY_FN;
    }




    public static void main(String[] args) {
        String [] myString = {"Ankara" ,"İzmir" ,"Adana"};
        UnaryOperator<String> myOperator=identityFunction();
        for(String s:myString){
            System.out.println(myOperator.apply(s));
        }
    }
}
