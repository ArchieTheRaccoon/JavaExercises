
package com.javaexercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Six {

  public static void main(String[] Args) {
    Six thisClass = new Six();
    thisClass.bmiCalculator(thisClass.userWeight(), thisClass.userHeight());
  }

  public void bmiCalculator(double weight, double height) {
    double bmiNumber = weight / Math.pow(height, 2);
    String result = "ERROR";
    if (bmiNumber < 18.5) {
      result = "Underweight";
    } else if (bmiNumber <= 24.9) {
      result = "Normal";
    } else if (bmiNumber <= 29.9) {
      result = "Overweight";
    } else if (bmiNumber <= 34.9) {
      result = "Obesity class I";
    } else if (bmiNumber <= 39.9) {
      result = "Obesity class II";
    } else if (bmiNumber >= 40) {
      result = "Obesity class III";
    }

    System.out.println("Your weight status is: " + result);
  }

  public double userWeight() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      try {
        System.out.print("Your weight in kg (If float, use \",\"): ");
        return scanner.nextDouble();
      } catch (InputMismatchException ignored) {
        System.out.println("Unvalid weight! Try again~");
        scanner.next();
      }
    }
  }

  public double userHeight() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      try {
        System.out.print("Your height (cm): ");
        return (scanner.nextDouble() / 100);
      } catch (InputMismatchException ignored) {
        System.out.println("Unvalid age! Try again~");
        scanner.next();
      }
    }
  }
}
