package com.Tap.Concurrency;

public class UnsafeSequenceRunnable implements Runnable {

    private final UnsafeSequence unsafeSequence;
    private final String name;

    public UnsafeSequenceRunnable(UnsafeSequence unsafeSequence, String name) {
        this.unsafeSequence = unsafeSequence;
        this.name = name;
    }

    @Override
    public void run() {
        int result = 0;

        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException ignore) {}

        for (int i = 0; i < 100000; ++i) {
            result = unsafeSequence.getNext();
        }

        System.out.println("Result from " + name + " is: " + result);
    }
}
