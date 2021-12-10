package com.effectivejava.G_Methods.CheckParametersForValidity;

import java.math.BigInteger;
import java.util.Objects;

public class SimpleMod {
    private static BigInteger value = BigInteger.valueOf(100);
    /**
     * Return a BigInteger whose value is (this mod m). This method differs from the remainder method in that
     * it always returns a non-negative BigInteger.
     * @param m the modulus which must bu positive
     * @return this mod m
     * @throws ArithmeticException if m is less than or equal to 0
     */
    private static BigInteger mod(BigInteger m ){
        /**
         * The Objects.requireNonNull method, added in Java 7, is flexible and
         * convenient, so there’s no reason to perform null checks manually anymore.
         * You can specify your own exception detail message if you wish. The method
         * returns its input, so you can perform a null check at the same time as you use a
         * value:
         */
        BigInteger v= Objects.requireNonNull(m,"value is null");
        if(v.signum()<=0){
            throw new ArithmeticException("Modulus <= 0 "+ v);
        }
        return value.mod(v);
    }

    public static void main(String[] args) {
        System.out.println(mod(BigInteger.valueOf(10)));
        /**
         * Occasionally, a computation implicitly performs a required validity check but
         * throws the wrong exception if the check fails. In other words, the exception that
         * the computation would naturally throw as the result of an invalid parameter value
         * doesn’t match the exception that the method is documented to throw. Under these
         * circumstances, you should use the exception translation idiom, described in
         * Item 73, to translate the natural exception into the correct one.
         *
         * Do not infer from this item that arbitrary restrictions on parameters are a good
         * thing. On the contrary, you should design methods to be as general as it is
         * practical to make them. The fewer restrictions that you place on parameters, the
         * better, assuming the method can do something reasonable with all of the
         * parameter values that it accepts. Often, however, some restrictions are intrinsic to
         * the abstraction being implemented.
         *
         * To summarize, each time you write a method or constructor, you should think
         * about what restrictions exist on its parameters. You should document these
         * restrictions and enforce them with explicit checks at the beginning of the method
         * body. It is important to get into the habit of doing this. The modest work that it
         * entails will be paid back with interest the first time a validity check fails.
         */
    }
}
