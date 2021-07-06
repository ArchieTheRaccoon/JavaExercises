package com.multithreading;

import java.util.HashMap;

public class GeneralBankManager {
    static int sparkasseID = 79090500;
    static int spardaBankID = 79050000;

    static int accountIDMatthes = 111333444;
    static int accountIDWeber = 111333555;
    static int accountIDWeberAndMatthes = 222333444;

    static BankCustomer matthes = new BankCustomer("Matthes");
    static BankCustomer weber = new BankCustomer("Weber");

    static HashMap<Integer, Bank> banks = new HashMap<>();

    public static void initialize() {
        banks.put(sparkasseID, new Bank("Sparkasse", sparkasseID));
        banks.put(spardaBankID, new Bank("Sparda Bank", spardaBankID));

        banks.get(sparkasseID).addAccountToThisBank(accountIDMatthes, new Account(accountIDMatthes, 7491.23));
        banks.get(sparkasseID).getAccount(accountIDMatthes).addBankCustomer(matthes);

        banks.get(sparkasseID).addAccountToThisBank(accountIDWeber, new Account(accountIDWeber, 5422.01));
        banks.get(sparkasseID).getAccount(accountIDWeber).addBankCustomer(weber);

        banks.get(spardaBankID).addAccountToThisBank(accountIDWeberAndMatthes, new Account(accountIDWeberAndMatthes, 73.00));
        banks.get(spardaBankID).getAccount(accountIDWeberAndMatthes).addBankCustomer(weber);
        banks.get(spardaBankID).getAccount(accountIDWeberAndMatthes).addBankCustomer(matthes);
    }
}
