package com.Tap.Concurrency;

import java.util.concurrent.Callable;

public class UnsafeSequenceCallable implements Callable<Integer> {

    private final UnsafeSequence unsafeSequence;
    private final String name;

    public UnsafeSequenceCallable(UnsafeSequence unsafeSequence, String name) {
        this.unsafeSequence = unsafeSequence;
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;

        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException ignore) {}

        for (int i = 0; i < 100000; ++i) {
            result = unsafeSequence.getNext();
        }

        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException ignore) {}

        return result;
    }
}
