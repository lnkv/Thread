
package com.company;

public class Main {
    public static long fact(int n) {
        if (n > 1) {
            return fact(n - 1) * n;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 20;
        Runnable task = () -> {
            System.out.println("factorial(" + n + ") = " + fact(n));
        };
        long start = System.nanoTime();
        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
            threads[i].join();
        }
        long stop = System.nanoTime();
        System.out.println("Время выполнения = " + (float) (stop - start) / 1000_000_000);
    }
}