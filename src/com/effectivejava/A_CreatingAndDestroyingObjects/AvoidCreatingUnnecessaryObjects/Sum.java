package com.effectivejava.A_CreatingAndDestroyingObjects.AvoidCreatingUnnecessaryObjects;

public class Sum {
    private static long sum() {
        long sum = 0L;
        // Long sum = 0L; using wrapper Long cause autoboxing coast.
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    private static long newSum(long a){
        if(a==Integer.MAX_VALUE){
            return a;
        }
        return newSum(a+1);
    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        sum();
        long end=System.currentTimeMillis();

        System.out.println("differ: "+ (end-start));
    }
}