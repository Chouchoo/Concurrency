package com.Tap.Visibility;

public class NoVisibility {
    private static boolean ready = false;
    private static int number = 0;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                ++number;
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();

        try {
            Thread.currentThread().sleep(1);
        } catch (Exception ignored) {}


        number = 1;
        ready = true;
    }


}
