package com.Tap.Deadlock;

public class LeftRightDeadlock {

    /* Minta egy jó deadlockhoz ♥
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {                       public void rightLeft() {
        synchronized (left) {                           synchronized (right) {
            synchronized (right) {                          synchronized (left) {
                doSomething(...);                             doSomething(...);
            }                                               }
        }                                               }
    }                                               }
     */

    public void transferMoney(Account fromAccount, Account toAccount, int amount) throws Exception {
        synchronized (fromAccount) {
            synchronized (toAccount) {
                if (fromAccount.debit(amount)) {
                    toAccount.credit(amount);
                }
            }
        }
    }

}
