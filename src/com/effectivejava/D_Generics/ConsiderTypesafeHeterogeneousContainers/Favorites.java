package com.effectivejava.D_Generics.ConsiderTypesafeHeterogeneousContainers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.List;

public class Favorites {
    private Map<Class<? extends Number>,Object> favorites =new HashMap<>();

    public void putFavorite(Class<? extends Number> type , Number obj){
        favorites.put(Objects.requireNonNull(type),obj);
    }

    public Number getFavorite(Class<? extends Number> type) {
        return type.cast(favorites.get(type));
    }

    // Achieving runtime type safety with a dynamic cast
//    public <T> void putFavoriteWithSafeType(Class<T> type, T instance) {
//        favorites.put(type, type.cast(instance));
//    }

    /**
     * The second limitation of the Favorites class is that it cannot be used on a
     * non-reifiable type (Item 28). In other words, you can store your favorite String or
     * String[], but not your favorite List<String>. If you try to store your favorite
     * List<String>, your program won’t compile. The reason is that you can’t get a
     * Class object for List<String>. The class literal List<String>.class is a syntax
     * error, and it’s a good thing, too. List<String> and List<Integer> share a
     * single Class object, which is List.class. It would wreak havoc with the internals
     * of a Favorites object if the “type literals” List<String>.class and
     * List<Integer>.class were legal and returned the same object reference. There
     * is no entirely satisfactory workaround for this limitation.
     */


    /**
     * In summary, the normal use of generics, exemplified by the collections APIs,
     * restricts you to a fixed number of type parameters per container. You can get
     * around this restriction by placing the type parameter on the key rather than the
     * container. You can use Class objects as keys for such typesafe heterogeneous
     * containers. A Class object used in this fashion is called a type token. You can also
     * use a custom key type. For example, you could have a DatabaseRow type representing
     * a database row (the container), and a generic type Column<T> as its key.
     */
    public static void main(String[] args) {
        Favorites favorites=new Favorites() ;
        //favorites.putFavorite(Integer[].class, new Integer[10]);
    }
}
