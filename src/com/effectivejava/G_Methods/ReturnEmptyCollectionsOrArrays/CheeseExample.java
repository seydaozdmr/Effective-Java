package com.effectivejava.G_Methods.ReturnEmptyCollectionsOrArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheeseExample {
    // Returns null to indicate an empty collection. Don’t do this!
    private final List<Cheese> cheeseList=new ArrayList<>();

    /**
     * @return a list containing all of the cheeses in the shop,
     * or null if no cheeses are available for purchase.
     */
    public List<Cheese> getCheeseList(){
        return cheeseList.isEmpty() ? null : new ArrayList<>(cheeseList);
    }

    /**
     * There is no reason to special-case the situation where no cheeses are available
     * for purchase. Doing so requires extra code in the client to handle the possibly null
     * return value, for example:
     * List<Cheese> cheeses = shop.getCheeses();
     * if (cheeses != null && cheeses.contains(Cheese.STILTON))
     * System.out.println("Jolly good, just the thing.");
     * This sort of circumlocution is required in nearly every use of a method that
     * returns null in place of an empty collection or array. It is error-prone, because the
     * programmer writing the client might forget to write the special-case code to handle
     * a null return. Such an error may go unnoticed for years because such methods
     * usually return one or more objects. Also, returning null in place of an empty container
     * complicates the implementation of the method returning the container.
     */

    //The right way to return a possibly empty collection
    public List<Cheese> getCheeses() {
        return new ArrayList<>(cheeseList);
    }
    /**
     * In the unlikely event that you have evidence suggesting that allocating empty
     * collections is harming performance, you can avoid the allocations by returning the
     * same immutable empty collection repeatedly, as immutable objects may be shared
     * freely (Item 17). Here is the code to do it, using the Collections.emptyList
     * method. If you were returning a set, you’d use Collections.emptySet; if you
     * were returning a map, you’d use Collections.emptyMap. But remember, this is
     * an optimization, and it’s seldom called for. If you think you need it, measure
     * performance before and after, to ensure that it’s actually helping:
     */

    // Optimization - avoids allocating empty collections
    public List<Cheese> getCheesesOpti() {
        return cheeseList.isEmpty() ? Collections.emptyList()
                : new ArrayList<>(cheeseList);
    }

}
