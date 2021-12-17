package com.effectivejava.J_Concurrency.SynchronizeAccessToSharedMutableData;

import java.util.concurrent.TimeUnit;

public class AppVolatile {
    private static volatile boolean stopRequested;
    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested){
                i++;
                System.out.println("stopRequest state is: "+stopRequested);
            }

            System.out.println(i);
        });

        backgroundThread.start();
        System.out.println("stopRequest state is: "+stopRequested);
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
        System.out.println("stopRequest state is: "+stopRequested);
    }

    /**
     * You do have to be careful when using volatile. Consider the following
     * method, which is supposed to generate serial numbers:
     * // Broken - requires synchronization!
     * private static volatile int nextSerialNumber = 0;
     * public static int generateSerialNumber() {
     * return nextSerialNumber++;
     * }
     */

    /**
     * The intent of the method is to guarantee that every invocation returns a unique
     * value (so long as there are no more than 232 invocations). The method’s state consists
     * of a single atomically accessible field, nextSerialNumber, and all possible
     * values of this field are legal. Therefore, no synchronization is necessary to protect
     * its invariants. Still, the method won’t work properly without synchronization.
     * The problem is that the increment operator (++) is not atomic. It performs two
     * operations on the nextSerialNumber field: first it reads the value, and then it
     * writes back a new value, equal to the old value plus one. If a second thread reads
     * the field between the time a thread reads the old value and writes back a new one,
     * the second thread will see the same value as the first and return the same serial
     * number. This is a safety failure: the program computes the wrong results.
     */

    /**
     * In summary, when multiple threads share mutable data, each thread that
     * reads or writes the data must perform synchronization. In the absence of
     * synchronization, there is no guarantee that one thread’s changes will be visible to
     * another thread. The penalties for failing to synchronize shared mutable data are
     * liveness and safety failures. These failures are among the most difficult to debug.
     * They can be intermittent and timing-dependent, and program behavior can vary
     * radically from one VM to another. If you need only inter-thread communication,
     * and not mutual exclusion, the volatile modifier is an acceptable form of
     * synchronization, but it can be tricky to use correctly.
     */
}
