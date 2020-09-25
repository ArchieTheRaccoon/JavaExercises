package com.javaexercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Five {
    public static int neededOperation;

    public static void main(String[] Agrs) {
            float result = 0;
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
            System.out.println("Your result: " + result);
    }

    public static float firstUserNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("First number: ");
                return scanner.nextFloat();
            } catch (InputMismatchException problem) {
                continue;
            }
        }
    }

    public static float secondUserNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Second number: ");
        return scanner.nextFloat();
    }
    public static int gettingUserWantedOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("(1)Sum, (2)Subtract, (3)Multiply, (4)Divide\nPut the number of wanted Operation: ");
        return scanner.nextInt();
    }
}
