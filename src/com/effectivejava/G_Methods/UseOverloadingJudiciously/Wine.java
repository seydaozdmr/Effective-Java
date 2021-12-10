package com.effectivejava.G_Methods.UseOverloadingJudiciously;

import java.util.List;

public class Wine {
    String name(){
        return " wine";
    }

    public static void main(String[] args) {
        List<Wine> wineList =List.of(new Wine(),new SparklingWine(),new Champagne());
        for(Wine w:wineList){
            System.out.println(w.name());
        }

        System.out.println(Math.pow(1.0154,36));

        /**
         * The name method is declared in class Wine and overridden in subclasses
         * SparklingWine and Champagne. As you would expect, this program prints out
         * wine, sparkling wine, and champagne, even though the compile-time type of the
         * instance is Wine in each iteration of the loop. The compile-time type of an object
         * has no effect on which method is executed when an overridden method is invoked;
         * the “most specific” overriding method always gets executed. Compare this to
         * overloading, where the runtime type of an object has no effect on which overloading
         * is executed; the selection is made at compile time, based entirely on the
         * compile-time types of the parameters.s
         */


        /**
         * To summarize, just because you can overload methods doesn’t mean you
         * should. It is generally best to refrain from overloading methods with multiple
         * signatures that have the same number of parameters. In some cases, especially
         * where constructors are involved, it may be impossible to follow this advice. In
         * these cases, you should at least avoid situations where the same set of parameters
         * can be passed to different overloadings by the addition of casts. If this cannot be
         * avoided, for example, because you are retrofitting an existing class to implement a
         * new interface, you should ensure that all overloadings behave identically when
         * passed the same parameters. If you fail to do this, programmers will be hard
         * pressed to make effective use of the overloaded method or constructor, and they
         * won’t understand why it doesn’t work.
         */
    }


}

class SparklingWine extends Wine{
    String name(){
        return " sparkling wine";
    }
}

class Champagne extends SparklingWine{
    String name()   {
        return " Champagne";
    }
}
