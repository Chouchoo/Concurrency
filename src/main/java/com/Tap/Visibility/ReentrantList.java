package com.Tap.Visibility;

import java.util.ArrayList;
import java.util.List;

public class ReentrantList {

    private static List<Integer> list = new ArrayList<>();

    //NOTE: Egy lock mindig reentrant, még inheritance során is.

    public static void main(String[] args) {
        synchronized (list) {

            //Ha egy lock nem lenne reentrant, itt deadlockot kapnék.

            synchronized (list) {
                System.out.println("I entered with the same lock twice");
            }
        }

        printMessage1();
    }

    private static void printMessage1() {
        synchronized (list) {
            printMessage2();
        }
    }

    private static void printMessage2() {
        //Ha egy lock nem lenne reentrant, itt is deadlockot kapnék.
        synchronized (list) {
            System.out.println("Locks are reentrant even through methods");
        }
    }
}
