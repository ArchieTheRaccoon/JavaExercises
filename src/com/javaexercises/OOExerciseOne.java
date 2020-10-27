
package com.javaexercises;

import java.util.Scanner;

public class OOExerciseOne {
  private double zaehler;
  private double nenner;
  private double sumOfZaehlers;
  private double sameNenner;

  public void scannerAndProcess() {
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Zähler: ");
      this.zaehler = scanner.nextInt();
      System.out.print("Nenner: ");
      setNenner(scanner.nextInt());
    } catch (Exception ignored) {
      System.out.println("Sorry, you can't type this here.");
    }

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
    return (int) this.zaehler;
  }

  public void setNenner(double value) {
    if (value == 0) {
      value = 1;
    }
    this.nenner = value;
  }

  public int getNenner() {
    return (int) this.nenner;
  }

  public int getSameZaehler() {
    return (int) this.sumOfZaehlers;
  }

  public int getSameNenner() {
    return (int) this.sameNenner;
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

  public void printBruch() {
    System.out.println(getZaehler() + "\n-\n" + getNenner());
  }

  public void printTwoProcessed() {
    System.out.println("Processed Bruch: \n" + getSameZaehler() + "\n-\n" + getSameNenner());
  }

  public static void main(String[] Args) {
    OOExerciseOne b1 = new OOExerciseOne();
    OOExerciseOne b2 = new OOExerciseOne();
    OOExerciseOne sameShortOperation = new OOExerciseOne();

    b1.scannerAndProcess();
    b1.printBruch();
    b2.scannerAndProcess();
    b2.printBruch();

    sameShortOperation.sumOfTwoAndProcess(b1.getZaehler(), b1.getNenner(), b2.getZaehler(), b2.getNenner());
    sameShortOperation.printTwoProcessed();
  }
}
