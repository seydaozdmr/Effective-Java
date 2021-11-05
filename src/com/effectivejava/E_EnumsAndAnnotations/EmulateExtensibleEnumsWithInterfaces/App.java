package com.effectivejava.E_EnumsAndAnnotations.EmulateExtensibleEnumsWithInterfaces;

import java.util.Arrays;
import java.util.Collection;

public class App {
    public static void main(String[] args) {
        test(ExtendedOperation.class,10.0,20.0);

        test2(Arrays.asList(ExtendedOperation.values()),2,5);
    }

    public static <T extends Enum<T> & Operation> void test (Class<T> opEnumType,double x,double y ){
        for(Operation op:opEnumType.getEnumConstants()){
            System.out.println("result : "+op.apply(x,y));
        }
    }

    public static void test2 (Collection <? extends Operation> opSet,double x,double y){
        for(Operation op:opSet){
            System.out.println("result : "+op.apply(x,y));
        }
    }
}
