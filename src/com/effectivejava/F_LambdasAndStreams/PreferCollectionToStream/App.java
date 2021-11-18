package com.effectivejava.F_LambdasAndStreams.PreferCollectionToStream;

import java.util.Iterator;
import java.util.stream.Stream;

public class App {
    /**
     * You may hear it said that streams are now the obvious choice to return a
     * sequence of elements, but as discussed in Item 45, streams do not make iteration
     * obsolete: writing good code requires combining streams and iteration judiciously.
     * If an API returns only a stream and some users want to iterate over the returned
     * sequence with a for-each loop, those users will be justifiably upset. It is especially
     * frustrating because the Stream interface contains the sole abstract method in the
     * Iterable interface, and Stream’s specification for this method is compatible with
     * Iterable’s. The only thing preventing programmers from using a for-each loop to
     * iterate over a stream is Stream’s failure to extend Iterable.
     */
    /**
     * Sadly, there is no good workaround for this problem. At first glance, it might
     * appear that passing a method reference to Stream’s iterator method would work.
     * The resulting code is perhaps a bit noisy and opaque, but not unreasonable:
     */
    private static Stream myStream=Stream.of(1,2,3,4,5,6,7,8,9,0);
    public static void main(String[] args) {

//
//        for(Stream s:App.myStream::iterator){
//
//        }

//        for(App s:(Iterable<App>) App.myStream::iterator){
//
//        }
//        Iterable<Stream> myIter=iterableOf(myStream);
        for (Iterator it = iterableOf(myStream).iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

    }
    /**
     * This client code works, but it is too noisy and opaque to use in practice. A better
     * workaround is to use an adapter method. The JDK does not provide such a
     * method, but it’s easy to write one, using the same technique used in-line in the
     * snippets above. Note that no cast is necessary in the adapter method because
     * Java’s type inference works properly in this context:
     * // Adapter from Stream<E> to Iterable<E>
     *
     * }
     */
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }
    /**
     * The Collection interface is a subtype of Iterable and has a stream method,
     * so it provides for both iteration and stream access. Therefore, Collection or an
     * appropriate subtype is generally the best return type for a public, sequencereturning
     * method.
     */

    /**
     * Arrays also provide for easy iteration and stream access with
     * the Arrays.asList and Stream.of methods. If the sequence you’re returning is
     * small enough to fit easily in memory, you’re probably best off returning one of the
     * standard collection implementations, such as ArrayList or HashSet. But do not
     * store a large sequence in memory just to return it as a collection.
     */

    /**
     * If the sequence you’re returning is large but can be represented concisely, consider
     * implementing a special-purpose collection. For example, suppose you want
     * to return the power set of a given set, which consists of all of its subsets. The
     * power set of {a, b, c} is {{}, {a}, {b}, {c}, {a, b}, {a, c}, {b, c}, {a, b, c}}. If a
     * set has n elements, its power set has 2n. Therefore, you shouldn’t even consider
     * storing the power set in a standard collection implementation. It is, however, easy
     * to implement a custom collection for the job with the help of AbstractList.
     */

    /**
     * In summary, when writing a method that returns a sequence of elements,
     * remember that some of your users may want to process them as a stream while
     * others may want to iterate over them. Try to accommodate both groups. If it’s feasible
     * to return a collection, do so. If you already have the elements in a collection
     * or the number of elements in the sequence is small enough to justify creating a
     * new one, return a standard collection such as ArrayList. Otherwise, consider
     * implementing a custom collection as we did for the power set. If it isn’t feasible to
     * return a collection, return a stream or iterable, whichever seems more natural. If,
     * in a future Java release, the Stream interface declaration is modified to extend
     * Iterable, then you should feel free to return streams because they will allow for
     * both stream processing and iteration.
     */
}

