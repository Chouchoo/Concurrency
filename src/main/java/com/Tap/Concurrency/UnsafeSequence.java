package com.Tap.Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class UnsafeSequence {

    private AtomicInteger value = new AtomicInteger(0);

    public int getNext() {
        return value.incrementAndGet();
        //Thread0 kiolvassa value értékét a memóriából.
        //Thread1 kiolvassa value értékét a memóriából.
        //Thread0 elvégzi a szükséges számítást
        //Thread1 elvégzi a szükséges számítást
        //Thread1 visszaírja value-be a kiszámított értéket.
        //Thread0 visszaírja value-be a kiszámított értéket.
    }
}
