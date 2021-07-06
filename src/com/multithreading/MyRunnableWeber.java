package com.multithreading;

import java.util.Random;

public class MyRunnableWeber implements Runnable{

    @Override
    public void run() {
        boolean finished = false;

        for (int x = 0; x < 10; x++) {
            int randomAmountOfEuro = new Random().nextInt((100 - 50) + 1) + 50;

            System.out.println(GeneralBankManager.weber.getNameOfCustomer() + " transfers " + randomAmountOfEuro + "€ from <Account " + GeneralBankManager.banks.get(GeneralBankManager.sparkasseID).getAccount(GeneralBankManager.accountIDWeber).getAccountID()
                    + "> from Bank <" + GeneralBankManager.banks.get(GeneralBankManager.sparkasseID).getBankName() + " " + GeneralBankManager.banks.get(GeneralBankManager.sparkasseID).getBankID()
                    + "> to <Account " + GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getAccount(GeneralBankManager.accountIDWeberAndMatthes).getAccountID()
                    + "> to Bank <" + GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getBankName() + " " + GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getBankID() + ">"
            );

            GeneralBankManager.banks.get(GeneralBankManager.sparkasseID).getAccount(GeneralBankManager.accountIDWeber).transfer(
                    randomAmountOfEuro,
                    GeneralBankManager.banks.get(GeneralBankManager.spardaBankID),
                    GeneralBankManager.accountIDWeberAndMatthes
            );
        }

        if (!Main.didThreadOneFinishedFirst()) {
            Main.threadTwoFinishedFirst();
        } else {
            System.out.println("Webes withdraws " + GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getAccount(GeneralBankManager.accountIDWeberAndMatthes).getBalance() + 100
                    + "€ from Account " + GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getAccount(GeneralBankManager.accountIDWeberAndMatthes).getAccountID()
                    + " from Bank " + GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getBankName() + " " + GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getBankID());

            GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getAccount(GeneralBankManager.accountIDWeberAndMatthes).withdraw(
                    GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getAccount(GeneralBankManager.accountIDWeberAndMatthes).getBalance() + 100
            );

            System.out.println("Current balance on <Account " + GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getAccount(GeneralBankManager.accountIDWeberAndMatthes).getAccountID()
                    + "> from Bank <" +  GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getBankName() + " " + GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getBankID()
                    + "> is " + GeneralBankManager.banks.get(GeneralBankManager.spardaBankID).getAccount(GeneralBankManager.accountIDWeberAndMatthes).getBalance() + "€"
            );
        }
    }
}
