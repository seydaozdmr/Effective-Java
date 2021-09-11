package com.effectivejava.A_CreatingAndDestroyingObjects.AvoidCreatingUnnecessaryObjects;


import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


public class Roman {


    private static final String ALPHA_NUMERIC_STRING = "!?&ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final Pattern ROMAN=Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$"
    );

    static boolean isRomanNumeral(String s){
        return ROMAN.matcher(s).matches();
    }

//    static boolean isRomanNumeral(String s) {
//        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
//                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
//    }




    public static void main(String[] args) {
        long start=System.nanoTime();
        System.out.println(isRomanNumeral("MCMLXXVI"));
        long end=System.nanoTime();
        System.out.println("differ: "+ (TimeUnit.MICROSECONDS.convert((end-start),TimeUnit.NANOSECONDS)));
    }
}
