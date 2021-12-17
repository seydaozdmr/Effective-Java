package com.effectivejava.H_GeneralProgramming.PreferForEachLoopsToTraditionalForLoops;

import java.util.Iterator;

public class Location implements Iterable<Location>{
    private String currentLocation;
    private Location next;

    public Location(String currentLocation, Location next) {
        this.currentLocation = currentLocation;
        this.next = next;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public Location getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "currentLocation='" + currentLocation + '\'' +
                '}';
    }

    @Override
    public Iterator<Location> iterator() {
        return new Iterator<Location>() {
            @Override
            public boolean hasNext() {
                //System.out.println("hasNext()");
                return next!=null;
            }

            @Override
            public Location next() {
                //System.out.println("next() :"+getCurrentLocation() + "nextLocation:"+next);
                Location n=next;
                next=next.next;
                return n;
            }
        };
    }
}
