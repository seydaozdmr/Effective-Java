package com.effectivejava.G_Methods.ReturnOptionalsJudiciously;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class App {
    /**
     * Prior to Java 8, there were two approaches you could take when writing a method
     * that was unable to return a value under certain circumstances. Either you could
     * throw an exception, or you could return null (assuming the return type was an
     * object reference type). Neither of these approaches is perfect. Exceptions should
     * be reserved for exceptional conditions (Item 69), and throwing an exception is
     * expensive because the entire stack trace is captured when an exception is created.
     * Returning null doesn’t have these shortcomings, but it has its own. If a method
     * returns null, clients must contain special-case code to deal with the possibility of
     * a null return, unless the programmer can prove that a null return is impossible. If a
     * client neglects to check for a null return and stores a null return value away in
     * some data structure, a NullPointerException may result at some arbitrary time
     * in the future, at some place in the code that has nothing to do with the problem.
     */

    /**
     * In Item 30, we showed this method to calculate the maximum value in a
     *     collection, according to its elements’ natural order.
     */

    // Returns maximum value in collection - throws exception if empty
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Empty collection");
        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        return result;
    }

    /**
     * This method throws an IllegalArgumentException if the given collection is
     * empty. We mentioned in Item 30 that a better alternative would be to return
     * Optional<E>. Here’s how the method looks when it is modified to do so:
     */

    public static <E extends Comparable<E>> Optional<E> max2 (Collection<E> c){
        if(c.isEmpty())
            return Optional.empty();

        E result=null;
        for(E e:c){
            if(result == null || e.compareTo(result)>0){
                result=Objects.requireNonNull(e);
            }
        }
        return Optional.of(result);
    }

    /**
     * Many terminal operations on streams return optionals. If we rewrite the max
     * method to use a stream, Stream’s max operation does the work of generating an
     * optional for us (though we do have to pass in an explicit comparator):
     */

    public static <E extends Comparable<E>> Optional<E> max3 (Collection<E> c){
        return c.stream().max(Comparator.naturalOrder());
    }

    /**
     * So how do you choose to return an optional instead of returning a null or
     * throwing an exception? Optionals are similar in spirit to checked exceptions
     * (Item 71), in that they force the user of an API to confront the fact that there may
     * be no value returned. Throwing an unchecked exception or returning a null allows
     * the user to ignore this eventuality, with potentially dire consequences. However,
     * throwing a checked exception requires additional boilerplate code in the client.
     *
     *
     */

    /**If a method returns an optional, the client gets to choose what action to take if
    the method can’t return a value. You can specify a default value:
    // Using an optional to provide a chosen default value
     */
    //String lastWordInLexicon = max(words).orElse("No words...");
    /**
    or you can throw any exception that is appropriate. Note that we pass in an
    exception factory rather than an actual exception. This avoids the expense of
    creating the exception unless it will actually be thrown:
     */
    // Using an optional to throw a chosen exception
    //Toy myToy = max(toys).orElseThrow(TemperTantrumException::new);


    /**
     * If you can prove that an optional is nonempty, you can get the value from the
     * optional without specifying an action to take if the optional is empty, but if you’re
     * wrong, your code will throw a NoSuchElementException:
     * // Using optional when you know there’s a return value
     * Element lastNobleGas = max(Elements.NOBLE_GASES).get();
     */

    /**
     * An Optional is an object that has to be allocated and initialized, and reading the
     * value out of the optional requires an extra indirection. This makes optionals
     * inappropriate for use in some performance-critical situations. Whether a particular
     * method falls into this category can only be determined by careful measurement
     * (Item 67).
     */

    /**
     * Returning an optional that contains a boxed primitive type is prohibitively
     * expensive compared to returning a primitive type because the optional has two
     * levels of boxing instead of zero. Therefore, the library designers saw fit to provide
     * analogues of Optional<T> for the primitive types int, long, and double. These
     * optional types are OptionalInt, OptionalLong, and OptionalDouble. They
     * contain most, but not all, of the methods on Optional<T>. Therefore, you should
     * never return an optional of a boxed primitive type, with the possible exception
     * of the “minor primitive types,” Boolean, Byte, Character, Short, and Float.
     */

    /**
     * In summary, if you find yourself writing a method that can’t always return a
     * value and you believe it is important that users of the method consider this
     * possibility every time they call it, then you should probably return an optional.
     * You should, however, be aware that there are real performance consequences
     * associated with returning optionals; for performance-critical methods, it may be
     * better to return a null or throw an exception. Finally, you should rarely use an
     * optional in any other capacity than as a return value.
     */
}
