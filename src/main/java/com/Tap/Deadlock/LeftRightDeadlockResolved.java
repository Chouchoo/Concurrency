package com.Tap.Deadlock;

public class LeftRightDeadlockResolved {

    private static final Object tieLock = new Object();

    private void transfer(Account fromAccount, Account toAccount, int amount) {
        if (fromAccount.debit(amount)) {
            toAccount.credit(amount);
        }
    }

    public void transferMoney(Account fromAccount, Account toAccount, int amount) {
        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);

        // X-ből Y-ba küldök. X = 100, Y = 1000;
        if (fromHash < toHash) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    transfer(fromAccount, toAccount, amount);
                }
            }
        //Y-ból X-be küldök. Y = 1000, X = 100;
        } else if (fromHash > toHash) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    transfer(fromAccount, toAccount, amount);
                }
            }
        //Ha M-ből N-be szeretnék és N-ből M-be, és M = 100 és N = 100;
        } else if (fromHash == toHash) {
            synchronized (tieLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        transfer(fromAccount, toAccount, amount);
                    }
                }
            }
        }
    }
}
