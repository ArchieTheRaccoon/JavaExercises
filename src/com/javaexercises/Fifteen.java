package com.javaexercises;

public class Fifteen {
    public static void main(String[] Args) {
        int[] integerArray = {0, 20};
        try {
            System.out.println(integerArray[2]);
        } catch (ArrayIndexOutOfBoundsException ignored) {
            System.out.println("The index 2 does not exist in the array integerArray!");
        }

        System.out.println("Index 1 in the integerArray is " + integerArray[1] + ".");

        try {
            int result = integerArray[1] / integerArray[0];
            System.out.println(result);
        } catch (ArithmeticException ignored) {
            System.out.println("Sorry, you cant devide by Zero!");
        }
    }
}
