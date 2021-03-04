package com.javaexercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {
    private int sum = 0;
    private int amountOfDiceSides = 0;
    private List<Integer> arrayOfNumbersFromDice = new ArrayList<Integer>();

    public Dice(int amountDiceSides) {
        amountOfDiceSides = amountDiceSides;
    }

    public static void main(String[] Args) { // In this main method i'm gonna show you how our Dice works
        int localAmountOfDiceSides = 6;
        Dice dice = new Dice(localAmountOfDiceSides);

        dice.multipleRoll(localAmountOfDiceSides); // this method rolls the dice as much times as you need it to
        dice.sum(); // this method gets the sum of numbers in array
        System.out.println("The sum is " + dice.getSum());
    }

    public void roll() {
        Random random = new Random();
        arrayOfNumbersFromDice.add((random.nextInt(amountOfDiceSides) + 1));
    }

    public void multipleRoll(int amountOfRoll) {
        Random random = new Random();
        for (int x = 0; x < amountOfRoll; x++) {
            arrayOfNumbersFromDice.add(random.nextInt(amountOfDiceSides));
        }
    }

    public void sum() {
        for (int x = 0; x < arrayOfNumbersFromDice.size(); x++) {
            sum += arrayOfNumbersFromDice.get(x);
        }
    }

    public void reset() {
        sum = 0;
        arrayOfNumbersFromDice.clear();
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
