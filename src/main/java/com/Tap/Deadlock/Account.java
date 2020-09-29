package com.Tap.Deadlock;

public class Account {

    private final String name;
    private Integer balance;

    public Account(String name, int credit) {
        this.name = name;
        this.balance = credit;
    }

    public boolean debit(int amount) {
        if (balance - amount < 0) {
            return false;
        } else {
            balance = balance - amount;
        }
        return true;
    }

    public void credit(int amount) {
        balance = balance + amount;
    }

    public Integer getBalance() {
        return balance;
    }
}
