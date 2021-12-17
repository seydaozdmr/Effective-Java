package com.effectivejava.J_Concurrency.SynchronizeAccessToSharedMutableData;

import java.util.concurrent.TimeUnit;

public class App {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }
    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            /**
             * while (!stopRequested)
             *                 i++;
             *                 Bu şekilde sonsuza kadar çalışmaya devam eder
             * Bunu değiştirmek için synchronized olan method yardımıyla stopRequest'in durumunu kontrol etmeliyiz
             */
            while (!stopRequested())
                i++;
            System.out.println(i);
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        //stopRequested = true;
        requestStop();
    }
}
