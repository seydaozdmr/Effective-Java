package com.effectivejava.B_MethodsCommontoAllObjects.ConsiderImplementingComparable;


import java.util.Comparator;

import static java.util.Comparator.comparingInt;

public class Computer implements Comparable<Computer> {
    /**
     * It is similar in character to Object’s equals method, except that it permits order comparisons
     * in addition to simple equality comparisons, and it is generic.
     * By implementing
     * Comparable, a class indicates that its instances have a natural ordering.
     */

    /**
     * Unlike the equals method, which imposes a global equivalence relation on all objects, compareTo
     * doesn’t have to work across objects of different types: when confronted with
     * objects of different types, compareTo is permitted to throw ClassCastException.
     */

    /**
     * If you want to add a value component to a class that implements Comparable, don’t
     * extend it; write an unrelated class containing an instance of the first class. Then
     * provide a “view” method that returns the contained instance.
     */

    private int id;
    private String type;
    private String model;

    public Computer(int id, String type, String model) {
        this.id = id;
        this.type = type;
        this.model = model;
    }


//    @Override
//    public int compareTo(Computer o) {
////        if(o.id>id)
////            return -1;
////        else if(o.id<id)
////            return 1;
////        else
////            return 0;
//        int result= Integer.compare(this.id,o.id);
//        if(result==0){
//            result= this.type.compareTo(o.type);
//            if(result==0){
//                result = this.model.compareTo(o.model);
//            }
//        }
//        return result;
//    }

    //doğrudan o1.hashCode() > o2.hashCode() demektense ki bu hatalara sebep olabilir Integer.compare() içerisinde
    //karşılaştırma yapılmalıdır
    static Comparator<Computer> hashCodeOrder= new Comparator<Computer>() {
        @Override
        public int compare(Computer o1, Computer o2) {
            /**
             * When comparing field values in the implementations of the compareTo
             * methods, avoid the use of the < and > operators. Instead, use the static compare
             * methods in the boxed primitive classes or the comparator construction methods in
             * the Comparator interface.
             */
            return Integer.compare(o1.hashCode(),o2.hashCode());
        }
    };

    // yada bu şekilde constuctor method ile Constructor üretebiliriz.
    static Comparator<Computer> hashCodeOrderStream = comparingInt(elem -> elem.hashCode());

    private static final Comparator<Computer> myComparator = comparingInt((Computer e) ->e.id )
            //eğer normal kıyaslama yapılması gerekiyor ise (e -> e.model) dersek s1.compareTo(s2) string
            //comparison gerçekleşir
            /**
             * There are also comparator construction methods for object reference types.
             * The static method, named comparing, has two overloadings. One takes a key
             * extractor and uses the keys’ natural order. The second takes both a key extractor
             * and a comparator to be used on the extracted keys.
             */
                                                                .thenComparing(e->e.model, (s1,s2)->{
                                                                    if(s1.length()>s2.length())
                                                                        return 1;
                                                                    else if(s1.length()<s2.length())
                                                                        return -1;
                                                                    else
                                                                        return 0;
                                                                })
                                                                .thenComparing(e->e.type);

    static Comparator<String> comparatorByLength = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length()> o2.length()){
                return 1;
            }else if(o1.length()<o2.length()){
                return -1;
            }return 0;
        }
    };
    public int compareTo(Computer other){
        return myComparator.compare(this,other);
    }



}
