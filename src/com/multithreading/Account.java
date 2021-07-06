package com.multithreading;

import java.util.ArrayList;

public class Account {
    private int accountID;
    private final ArrayList<BankCustomer> bankCustomers = new ArrayList<>();
    private double balance;

    public Account(int accountID, double balance) {
        this.accountID = accountID;
        this.balance = balance;
    }

    public void addBankCustomer(BankCustomer bankCustomer) {
        this.bankCustomers.add(bankCustomer);
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccountID() {
        return this.accountID;
    }

    public void withdraw(double amountToWithdraw) {
        this.balance -= amountToWithdraw;
    }

    public void advance(double amountToAdvance) {
        this.balance += amountToAdvance;
    }

    public void transfer(double amountToTransfer, Bank bankToTransferTo, int accountIDToTransferTo) {
        this.balance =- amountToTransfer;
        bankToTransferTo.getAccount(accountIDToTransferTo).advance(amountToTransfer);
    }
}
