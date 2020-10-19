package com.javaexercises;

import java.util.Random;

public class Twelve {
    public static void main(String[] Args) {
        Twelve thisClass = new Twelve();
        thisClass.createTwoStringsAndCompare();
    }
    
    public void createTwoStringsAndCompare() {
        Twelve thisClass = new Twelve();
        StringBuilder firstString = thisClass.getString();
        StringBuilder secondString = thisClass.getString();
        System.out.println("String 1: " + firstString);
        System.out.println("String 2: " + secondString);
        System.out.println("String 1 has " + (firstString.length() + 1) + " characters.");
        System.out.println("String 2 has " + (secondString.length() + 1) + " characters.");
        if (firstString.length() == secondString.length()) {
            System.out.println("Both Strings have the same length!");
        } else {
            System.out.println("They dont have the same length!");
        }
        if (firstString == secondString) {
            System.out.println("String 1 and String 2 are equal!");
        } else {
            System.out.println("String 1 and String 2 are not equal!");
        }
    }

    public StringBuilder getString() {
        String alphabet = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
        String[] alphabetArray = alphabet.split(",");
        Twelve thisClass = new Twelve();
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < thisClass.randomNumber(); i++) {
            randomString.append(alphabetArray[thisClass.randomNumberLetter()]);
        }
        return randomString;
    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt((10 - 5) + 1) + 5;
    }

    public int randomNumberLetter() {
        Random random = new Random();
        return random.nextInt((25 - 5) + 1) + 5;
    }
}
