package com.javaexercises;

import java.util.Random;

public class DiceForMaexle {
    private int amountOfDiceSides = 0;

    public DiceForMaexle(int amountDiceSides) {
        amountOfDiceSides = amountDiceSides;
    }

    public int roll() {
        Random random = new Random();
        return random.nextInt(amountOfDiceSides);
    }
}
