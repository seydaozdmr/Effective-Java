package com.effectivejava.J_Concurrency.AvoidExcessiveSynchronization;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ObservableSet<String> messages=new ObservableSet<>(new HashSet<>());
//        Set<String> observer1=new TreeSet<>();
//        messages.addObserver(new SetObserver<String>() {
//            @Override
//            public void added(ObservableSet<String> set, String element) {
//                observer1.add(element);
//            }
//        });


        /**
         * When we run this program, we don’t get an exception; we get a deadlock. The
         * background thread calls s.removeObserver, which attempts to lock observers,
         * but it can’t acquire the lock, because the main thread already has the lock. All the
         * while, the main thread is waiting for the background thread to finish removing the
         * observer, which explains the deadlock.
         */
        System.out.println(Thread.currentThread().getName()+" is working...");
        messages.addObserver(new SetObserver<>() {
            public void added(ObservableSet<String> set, String element) {
                System.out.println(element+" is added");
                //9'a geldiği zaman deadlock oluyor...
                if (element.equals("9")) {
                    ExecutorService exec =
                            Executors.newSingleThreadExecutor();
                    try {
                        //bu gözlemciyi silmek için lock'a ihtiyacı var fakat lock'u main thread tutuyor.
                        //main thread'i bekliyor. main thread ise bu thread'in işini bitirmesini bekliyor.
                        //Bu duruma deadlock diyoruz.
                        exec.submit(() -> set.removeObserver(this)).get();
                        System.out.println(Thread.currentThread().getName()+" is working...");
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });


        //a kimi gözleyeceği, b ise eklenen eleman
//        messages.addObserver((a,b)->System.out.println("Birinci Gözlemci = "+b));
//        messages.addObserver((a,b)->System.out.println(a.toString()));
//        messages.addObserver((a,b)->System.out.println("İkinci gözlemci =" +b));
//        messages.addObserver((a,b)->System.out.println("Üçüncü gözlemci = "+ b));
        for(int i=0;i<10;i++){
            messages.add(String.valueOf(i));
        }

        messages.getObserver();





//        for(int i=0;i<1000;i++){
//            messages.add(String.valueOf(i));
//        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        observer1.stream().map(p->Integer.valueOf(p)).sorted().forEach(System.out::println);

    }

    /**
     * As in the first example, which resulted in an exception, the calling thread already holds
     * the lock, so the thread will succeed when it tries to reacquire the lock, even though
     * another conceptually unrelated operation is in progress on the data guarded by the
     * lock. The consequences of such a failure can be catastrophic. In essence, the lock
     * has failed to do its job. Reentrant locks simplify the construction of multithreaded
     * object-oriented programs, but they can turn liveness failures into safety failures.
     */

    /**
     * As a rule, you should do as little work as possible inside synchronized
     * regions. Obtain the lock, examine the shared data, transform it as necessary, and
     * drop the lock. If you must perform some time-consuming activity, find a way to
     * move it out of the synchronized region without violating the guidelines in Item 78.
     */

    /**
     * If you are writing a mutable class, you have two options: you can omit all
     * synchronization and allow the client to synchronize externally if concurrent use is
     * desired, or you can synchronize internally, making the class thread-safe (Item 82).
     */

    /**
     * If you do synchronize your class internally, you can use various techniques to
     * achieve high concurrency, such as lock splitting, lock striping, and nonblocking
     * concurrency control. These techniques are beyond the scope of this book, but they
     * are discussed elsewhere [Goetz06, Herlihy08].
     */

    /**
     * In summary, to avoid deadlock and data corruption, never call an alien method
     * from within a synchronized region. More generally, keep the amount of work that
     * you do from within synchronized regions to a minimum. When you are designing
     * a mutable class, think about whether it should do its own synchronization. In the
     * multicore era, it is more important than ever not to oversynchronize. Synchronize
     * your class internally only if there is a good reason to do so, and document your
     * decision clearly (Item 82).
     */
    Map<String,Integer> myMap = Collections.synchronizedMap(new HashMap<>());


}
