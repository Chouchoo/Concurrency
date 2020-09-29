package com.Tap.Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MainCallable {

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        UnsafeSequence unsafeSequence = new UnsafeSequence();

        List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 2; ++i) {
            UnsafeSequenceCallable usf = new UnsafeSequenceCallable(unsafeSequence, "Thread" + i);
            futureList.add(ex.submit(usf));
        }

        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException ignore) {}

        futureList.get(0).cancel(true);

        long start = System.nanoTime();
        try {
            System.out.println("Future0: " + futureList.get(0).get());
            System.out.println("Future1: " + futureList.get(1).get(1, TimeUnit.SECONDS));
        } catch (Exception ignored) {}

        long end = System.nanoTime();
        System.out.println("I waited for: " + TimeUnit.NANOSECONDS.toMillis(end - start));

        ex.shutdown();
    }

}
