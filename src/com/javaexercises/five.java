package com.javaexercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class five {
    public static int neededOperation;

    public static void main(String[] Agrs) {
            float result;
            neededOperation = gettingUserWantedOperation();
            while (neededOperation <= 0 | neededOperation >= 5) {
                System.out.println("This operation doesn't exist, please type number of an existing operation!");
                neededOperation = gettingUserWantedOperation();
            }

            if (neededOperation == 1) {
                result = firstUserNumber() + secondUserNumber();
            } else if (neededOperation == 2) {
                result = firstUserNumber() - secondUserNumber();
            } else if (neededOperation == 3) {
                result = firstUserNumber() * secondUserNumber();
            } else {
                result = firstUserNumber() / secondUserNumber();
            }
            if (result < 1_000_000) {
                System.out.println("Your result: " + result);
            } else {
                System.out.println("OMG THIS NUMBER IS TOO HUGE, SENPAI~");
            }
    }

    public static float firstUserNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("First number: ");
                return scanner.nextFloat();
            } catch (InputMismatchException ignored) {
                System.out.println("Sorry, you can only input numbers here.");
                scanner.next();
            }
        }
    }

    public static float secondUserNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Second number: ");
                return scanner.nextFloat();
            } catch (InputMismatchException ignored) {
                System.out.println("Sorry, you can only input numbers here.");
                scanner.nextFloat();
            }
        }
    }
    public static int gettingUserWantedOperation() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("(1)Sum, (2)Subtract, (3)Multiply, (4)Divide\nPut the number of wanted Operation: ");
                return scanner.nextInt();
            } catch (InputMismatchException ignored) {
                System.out.println("Sorry, you can only input numbers here.");
                scanner.next();
            }
        }
    }
}
