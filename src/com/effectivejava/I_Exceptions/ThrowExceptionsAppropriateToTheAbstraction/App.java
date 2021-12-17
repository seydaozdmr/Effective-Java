package com.effectivejava.I_Exceptions.ThrowExceptionsAppropriateToTheAbstraction;

import java.util.List;

public class App {


    /**
     * It is disconcerting when a method throws an exception that has no apparent
     * connection to the task that it performs. This often happens when a method
     * propagates an exception thrown by a lower-level abstraction. Not only is it
     * disconcerting, but it pollutes the API of the higher layer with implementation
     * details. If the implementation of the higher layer changes in a later release, the
     * exceptions it throws will change too, potentially breaking existing client programs.
     * To avoid this problem, higher layers should catch lower-level exceptions
     * and, in their place, throw exceptions that can be explained in terms of the
     * higher-level abstraction. This idiom is known as exception translation:
     */

    /**
     * Here is an example of exception translation taken from the
     * AbstractSequentialList class, which is a skeletal implementation (Item 20) of
     * the List interface. In this example, exception translation is mandated by the
     * specification of the get method in the List<E> interface:
     * /**
     * * Returns the element at the specified position in this list.
     * * @throws IndexOutOfBoundsException if the index is out of range
     * * ({@code index < 0 || index >= size()}).
     * */

//    class TestList <E> implements List<E> {
//        public E get(int index) {
//            ListIterator<E> i = listIterator(index);
//            try {
//                return i.next();
//            } catch (NoSuchElementException e) {
//                throw new IndexOutOfBoundsException("Index: " + index);
//            }
//        }
//    }

    /**
     * A special form of exception translation called exception chaining is called for
     * in cases where the lower-level exception might be helpful to someone debugging
     * the problem that caused the higher-level exception. The lower-level exception (the
     * cause) is passed to the higher-level exception, which provides an accessor method
     * (Throwable’s getCause method) to retrieve the lower-level exception:
     */

    /**
     * While exception translation is superior to mindless propagation of exceptions
     * from lower layers, it should not be overused. Where possible, the best
     * way to deal with exceptions from lower layers is to avoid them, by ensuring that
     * lower-level methods succeed. Sometimes you can do this by checking the validity
     * of the higher-level method’s parameters before passing them on to lower layers.
     */

    /**
     * In summary, if it isn’t feasible to prevent or to handle exceptions from lower
     * layers, use exception translation, unless the lower-level method happens to
     * guarantee that all of its exceptions are appropriate to the higher level. Chaining
     * provides the best of both worlds: it allows you to throw an appropriate higher-level
     * exception, while capturing the underlying cause for failure analysis (Item 75).
     */
}
