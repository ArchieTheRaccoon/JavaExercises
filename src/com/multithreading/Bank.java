package com.multithreading;

import java.util.HashMap;

public class Bank {
    private String bankName;
    private int bankID;
    private final HashMap<Integer, Account> accounts = new HashMap<>();

    public Bank(String bankName, int bankID) {
        this.bankName = bankName;
        this.bankID = bankID;
    }

    public void addAccountToThisBank(int accountID, Account account) {
        accounts.put(accountID, account);
    }

    public Account getAccount(int accountID) {
        return this.accounts.get(accountID);
    }

    public String getBankName() {
        return this.bankName;
    }

    public int getBankID() {
        return this.bankID;
    }
}
