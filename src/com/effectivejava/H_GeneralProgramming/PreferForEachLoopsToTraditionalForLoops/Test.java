package com.effectivejava.H_GeneralProgramming.PreferForEachLoopsToTraditionalForLoops;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Location ankara =new Location("Ankara" ,null);
        Location afyon = new Location("Afyon", ankara);
        Location burdur =new Location("Burdur", afyon);
        Location bucak = new Location("Bucak",burdur);
        Location antalya = new Location("Antalya", bucak);


//        for (Iterator<Location> it = antalya.iterator(); it.hasNext(); ) {
//            Thread.sleep(1000);
//            System.out.println(it.next());
//        }

        for(Location l:antalya){
            System.out.println(l);
        }



    }

}
