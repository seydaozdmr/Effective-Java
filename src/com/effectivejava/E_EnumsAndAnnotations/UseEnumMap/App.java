package com.effectivejava.E_EnumsAndAnnotations.UseEnumMap;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class App {
    public static void main(String[] args) {
        //set array
        Set<Plant> [] plantsByLifeCycle = (Set<Plant> [])  new Set[Plant.LifeCycle.values().length];
        //System.out.println(plantsByLifeCycle.getClass());
        for(int i=0;i< plantsByLifeCycle.length;i++){
            plantsByLifeCycle[i]=new HashSet<>();
        }

        List<Plant> garden=List.of(new Plant("avocado", Plant.LifeCycle.ANNUAL),
                new Plant("nar", Plant.LifeCycle.BIENNIAL),
                new Plant("elma", Plant.LifeCycle.PERENNIAL),
                new Plant("muz", Plant.LifeCycle.BIENNIAL),
                new Plant("limon", Plant.LifeCycle.ANNUAL));

        Plant[] garden2= {
                new Plant("avocado", Plant.LifeCycle.ANNUAL),
                new Plant("nar", Plant.LifeCycle.BIENNIAL),
                new Plant("elma", Plant.LifeCycle.PERENNIAL),
                new Plant("muz", Plant.LifeCycle.BIENNIAL),
                new Plant("limon", Plant.LifeCycle.ANNUAL)
        };

        System.out.println(garden);
        for(Plant p:garden){
            //p elemanının ordinal sırasına göre diziye ekler.
            //örnek annual-> ordinal 1 ise dizinin 1.sırasındaki hashSet'e ekler
            //dolaysıyla limon'a sıra geldiğinde onu'da 1. sıradaki hashSet'e ekler ordinal number'a
            //göre elemanları toplar
            //fakat bu sağlıklı değildir burada hardcode edilmiş olur.
            /**
             * Because the array does not know what its index represents,
             * you have to label the output manually.
             */
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        /**
         * But the most serious problem with
         * this technique is that when you access an array that is indexed by an enum’s ordinal,
         * it is your responsibility to use the correct int value; ints do not provide the
         * type safety of enums. If you use the wrong value, the program will silently do the
         * wrong thing or—if you’re lucky—throw an ArrayIndexOutOfBoundsException.
         */
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }


        /**There is a much better way to achieve the same effect. The array is effectively
        serving as a map from the enum to a value, so you might as well use a Map. More
        specifically, there is a very fast Map implementation designed for use with enum
        keys, known as java.util.EnumMap. Here is how the program looks when it is
        rewritten to use EnumMap:
         */
        // Using an EnumMap to associate data with an enum
        //key olarak enumları, value olarak enumları kullanan bitkileri set olarak veriyoruz
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle2 = new EnumMap<>(Plant.LifeCycle.class);
        //putting Plant.LifeCycle enum values...
        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle2.put(lc, new HashSet<>());
        //putting each garden element to set by corresponding Plant.LifeCycle enum constant.
        for (Plant p : garden)
            plantsByLifeCycle2.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle2);


        /**
         * Buradaki stream ile garden2 [] dizisinin elemanlarını LifeCycle enum değerlerine göre Map'in içerisinde topladık
         * map'in key değerleri enum LifeCycle, value değerleri ise List<Plant>
         */
        Map<Plant.LifeCycle,List<Plant>> myPlants = Arrays.stream(garden2).collect(Collectors.groupingBy(p->p.lifeCycle));
        System.out.println(Arrays.stream(garden2).collect(groupingBy(p->p.lifeCycle)));

        /**
         * The problem with this code is that it chooses its own map implementation, and in
         * practice it won’t be an EnumMap, so it won’t match the space and time performance
         * of the version with the explicit EnumMap. To rectify this problem, use the three
         * parameter form of Collectors.groupingBy, which allows the caller to specify
         * the map implementation using the mapFactory parameter:
         */
        EnumMap<Plant.LifeCycle,Set<Plant>> myEnumMapPlants= Arrays.stream(garden2)
                                                                    .collect(groupingBy(p->p.lifeCycle
                                                                            ,() -> new EnumMap<>(Plant.LifeCycle.class),
                                                                            toSet()));

        /**
         * Yukarıdaki implementasyonu garden List<Plant> listesine göre aşağıda yeniden düzenledim
         * ikisinin uygulanması arasında bir fark bulunmuyor.
         */
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycleStream = new EnumMap<>(Plant.LifeCycle.class);

        plantsByLifeCycleStream = garden.stream().collect(groupingBy(p->p.lifeCycle , ()-> new EnumMap<>(Plant.LifeCycle.class), toSet()));
        System.out.println(plantsByLifeCycleStream);
        System.out.println(plantsByLifeCycleStream.getClass());

    }
}
