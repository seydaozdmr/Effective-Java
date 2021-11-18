package com.effectivejava.F_LambdasAndStreams.FavorTheUseStandartFunctionalInterfaces;

import com.effectivejava.C_ClassesAndInterfaces.PreferInterfacesToAbstractClasses.AbstractMapEntry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;

public class App {
    public static void main(String[] args) {
        Map<String,Integer> myMap = Map.of("Hasan",1,"Ali",3,"Mahmut",5,"Kazım",8);

        BiPredicate<Map,Map.Entry> myFunction2= (e,t) ->{
            if (e.size() > 3) {
                e.remove(t);
                return true;
            }
            return false;
        };

        /**
         * Consider LinkedHashMap. You can use this class as a cache by overriding its
         * protected removeEldestEntry method, which is invoked by put each time a new
         * key is added to the map. When this method returns true, the map removes its
         * eldest entry, which is passed to the method. The following override allows the
         * map to grow to one hundred entries and then deletes the eldest entry each time a
         * new key is added, maintaining the hundred most recent entries:
         */
        Map<String,Integer> testMap = new LinkedHashMap<>();






        EldestEntryRemovalFunction myFunction= (map,elem)->{
            if(map.containsKey(elem.getKey())){
                map.remove(elem.getKey());
                return true;
            }
            return false;
        };
        System.out.println(myMap);

        myFunction.remove(myMap, new AbstractMapEntry() {
            @Override
            public Object getKey() {
                return "Kazım";
            }

            @Override
            public Object getValue() {
                return 8;
            }
        });

        System.out.println(myMap);

    }


}
