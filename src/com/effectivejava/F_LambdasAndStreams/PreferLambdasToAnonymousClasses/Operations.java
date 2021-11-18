package com.effectivejava.F_LambdasAndStreams.PreferLambdasToAnonymousClasses;

import java.util.function.DoubleBinaryOperator;

public enum Operations {
    /**
     * Enum sabitini oluştururken constructor içindeki DoubleBinaryOperator functional interface değişkenini
     * yapılandırıyoruz. Hangi operator'ü kullanacaksa kendi içerisinde onun yapacağı fonksiyon da oluşuyor.
     * apply() ile çağrıldığında yapılandırılmış olan bu fonksiyon çalışıyor ve işlemi dönüyor.
     */

    /**
     * Unlike methods and classes, lambdas lack names and documentation; if a
     * computation isn’t self-explanatory, or exceeds a few lines, don’t put it in a
     * lambda.
     */
    PLUS("+",  (x,y)-> x+y ) ,
    MINUS("-" , (x,y)-> x-y) ,
    TIMES("*", (x,y)-> x*y),
    DIVIDE("/", (x,y) -> x/y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    private Operations(String symbol,DoubleBinaryOperator op){
        this.symbol=symbol;
        this.op=op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x,double y){
        return op.applyAsDouble(x,y);
    }

    /**
     * Likewise, you might think that anonymous classes are obsolete in the era of
     * lambdas. This is closer to the truth, but there are a few things you can do with
     * anonymous classes that you can’t do with lambdas. Lambdas are limited to functional
     * interfaces. If you want to create an instance of an abstract class, you can do
     * it with an anonymous class, but not a lambda. Similarly, you can use anonymous
     * classes to create instances of interfaces with multiple abstract methods. Finally, a
     * lambda cannot obtain a reference to itself. In a lambda, the this keyword refers to
     * the enclosing instance, which is typically what you want. In an anonymous class,
     * the this keyword refers to the anonymous class instance. If you need access to the
     * function object from within its body, then you must use an anonymous class.
     */
}
