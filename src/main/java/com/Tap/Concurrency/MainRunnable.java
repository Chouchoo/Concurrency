package com.Tap.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainRunnable {

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        UnsafeSequence unsafeSequence = new UnsafeSequence();

        for (int i = 0; i < 2; ++i) {
            UnsafeSequenceRunnable usf = new UnsafeSequenceRunnable(unsafeSequence, "Thread" + i);
            ex.execute(usf);
        }

        ex.shutdown();
    }
}
