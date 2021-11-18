package com.effectivejava.F_LambdasAndStreams.FavorTheUseStandartFunctionalInterfaces;

import java.util.Map;

public interface EldestEntryRemovalFunction <K,V>{
    boolean remove (Map<K,V> map, Map.Entry<K,V> eldest);
    /**
     * If one of the standard functional interfaces does the job, you should generally
     * use it in preference to a purpose-built functional interface. This will make
     * your API easier to learn, by reducing its conceptual surface area, and will provide
     * significant interoperability benefits, as many of the standard functional interfaces
     * provide useful default methods. The Predicate interface, for instance, provides
     * methods to combine predicates. In the case of our LinkedHashMap example, the
     * standard BiPredicate<Map<K,V>, Map.Entry<K,V>> interface should be used in
     * preference to a custom EldestEntryRemovalFunction interface.
     */

}
