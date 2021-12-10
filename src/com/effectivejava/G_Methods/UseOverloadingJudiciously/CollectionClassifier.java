package com.effectivejava.G_Methods.UseOverloadingJudiciously;

import java.math.BigInteger;
import java.util.*;

public class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "Set";
    }
    public static String classify(List<?> lst) {
        return "List";
    }

    /**
     *Overload olan methodlardan hangisinin çağırılacağı compiletime da belli oluyor
     * bu yüzden yukarıdaki methodlar çağrılmaz
     */
    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }
    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };
        for (Collection<?> c : collections)
            System.out.println(classify(c));
    }
    /**
     * The behavior of this program is counterintuitive because selection among
     * overloaded methods is static, while selection among overridden methods is
     * dynamic. The correct version of an overridden method is chosen at runtime,
     * based on the runtime type of the object on which the method is invoked. As a
     * reminder, a method is overridden when a subclass contains a method declaration
     * with the same signature as a method declaration in an ancestor. If an instance
     * method is overridden in a subclass and this method is invoked on an instance of
     * the subclass, the subclass’s overriding method executes, regardless of the compiletime
     * type of the subclass instance.
     */
}
