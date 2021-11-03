package com.effectivejava.D_Generics.FavorGenericTypes;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class RestrictedGenerics {
    /**
     * There are some generic types that restrict the permissible values of their type
     * parameters. For example, consider java.util.concurrent.DelayQueue, whose
     * declaration looks like this:
     * class DelayQueue<E extends Delayed> implements BlockingQueue<E>
     * The type parameter list (<E extends Delayed>) requires that the actual type
     * parameter E be a subtype of java.util.concurrent.Delayed. This allows the
     * DelayQueue implementation and its clients to take advantage of Delayed methods
     * on the elements of a DelayQueue, without the need for explicit casting or the risk
     * of a ClassCastException. The type parameter E is known as a bounded type
     * parameter. Note that the subtype relation is defined so that every type is a subtype
     * of itself [JLS, 4.10], so it is legal to create a DelayQueue<Delayed>.
     */

    //this type of must sub class of Delayed so, implementation of this class not explicitly cast type E
    class DelayQueue<E extends Delayed> implements BlockingQueue<E> {

        @Override
        public boolean add(E e) {
            return false;
        }

        @Override
        public boolean offer(E e) {
            return false;
        }

        @Override
        public E remove() {
            return null;
        }

        @Override
        public E poll() {
            return null;
        }

        @Override
        public E element() {
            return null;
        }

        @Override
        public E peek() {
            return null;
        }

        @Override
        public void put(E e) throws InterruptedException {

        }

        @Override
        public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public E take() throws InterruptedException {
            return null;
        }

        @Override
        public E poll(long timeout, TimeUnit unit) throws InterruptedException {
            return null;
        }

        @Override
        public int remainingCapacity() {
            return 0;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public int drainTo(Collection<? super E> c) {
            return 0;
        }

        @Override
        public int drainTo(Collection<? super E> c, int maxElements) {
            return 0;
        }
    }
}
