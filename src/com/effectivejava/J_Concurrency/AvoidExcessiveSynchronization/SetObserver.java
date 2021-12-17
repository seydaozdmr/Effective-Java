package com.effectivejava.J_Concurrency.AvoidExcessiveSynchronization;

public interface SetObserver<E> {
    /**
     * Observers subscribe to notifications by invoking the addObserver method
     * and unsubscribe by invoking the removeObserver method. In both cases, an
     * instance of this callback interface is passed to the method.
     * @param set
     * @param element
     */
    void added(ObservableSet<E> set,E element);
}
