package com.javaexercises;

import java.util.Scanner;

public class Sixteen {
    private double zaehler;
    private double nenner;
    private double sumOfZaehlers;
    private double sameNenner;
    public void scannerAndProcess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zähler: ");
        this.zaehler = scanner.nextInt();
        System.out.print("Nenner: ");
        this.nenner = scanner.nextInt();

        boolean isZaehlerBigger = this.zaehler > this.nenner;
        if (isZaehlerBigger) {
            for (double i = this.zaehler; i >= 1; i = i - 1) {
                if (this.zaehler % i == 0 && this.nenner % i == 0) {
                    this.zaehler = this.zaehler / i;
                    this.nenner = this.nenner / i;
                }
            }
        } else {
            for (double i = this.nenner; i >= 1; i = i - 1) {
                if (this.nenner % i == 0 && this.zaehler % i == 0) {
                    this.zaehler = this.zaehler / i;
                    this.nenner = this.nenner / i;
                }
            }
        }
    }
    public int getZaehler() {
        return (int)this.zaehler;
    }
    public int getNenner() {
        return (int)this.nenner;
    }
    public int getSameZaehler() {
        return (int)this.sumOfZaehlers;
    }
    public int getSameNenner() {
        return (int)this.sameNenner;
    }
    public void sumOfTwoAndProcess(int firstZaehler, int firstNenner, int secordZaehler, int secondNenner) {
        this.sameNenner = firstNenner * secondNenner;
        double sameFirstZaehler = firstZaehler * secondNenner;
        double sameSecondZaehler = secordZaehler * firstNenner;
        this.sumOfZaehlers = sameFirstZaehler + sameSecondZaehler;

        boolean isZaehlerBigger = this.sumOfZaehlers > this.sameNenner;
        if (isZaehlerBigger) {
            for (double i = this.sumOfZaehlers; i >= 1; i = i - 1) {
                if (this.sumOfZaehlers % i == 0 && this.sameNenner % i == 0) {
                    this.sumOfZaehlers = this.sumOfZaehlers / i;
                    this.sameNenner = this.sameNenner / i;
                }
            }
        } else {
            for (double i = this.sameNenner; i >= 1; i = i - 1) {
                if (this.sameNenner % i == 0 && this.sumOfZaehlers % i == 0) {
                    this.sumOfZaehlers = this.sumOfZaehlers / i;
                    this.sameNenner = this.sameNenner / i;
                }
            }
        }
    }
    public static void main(String[] Args) {
        Sixteen firstOperation = new Sixteen();
        Sixteen secondOperation = new Sixteen();
        Sixteen sameShortOperation = new Sixteen();

        firstOperation.scannerAndProcess();
        System.out.println(firstOperation.getZaehler() + "\n-\n" + firstOperation.getNenner());
        secondOperation.scannerAndProcess();
        System.out.println(secondOperation.getZaehler() + "\n-\n" + secondOperation.getNenner());

        sameShortOperation.sumOfTwoAndProcess(firstOperation.getZaehler(), firstOperation.getNenner(), secondOperation.getZaehler(), secondOperation.getNenner());
        System.out.println("Processed sum of those two: \n" + sameShortOperation.getSameZaehler() + "\n-\n" + sameShortOperation.getSameNenner());
    }
}
