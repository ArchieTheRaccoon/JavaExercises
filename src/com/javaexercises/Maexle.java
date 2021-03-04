package com.javaexercises;

import java.util.ArrayList;
import java.util.List;

public class Maexle {
    int amountOfPlayers = 0;
    int diceFirst;
    int diceSecond;
    DiceForMaexle dice1 = new DiceForMaexle(6);
    DiceForMaexle dice2 = new DiceForMaexle(6);

    public Maexle(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    }

    public static void main(String[] Args) {
        Maexle maexle = new Maexle(3);
        maexle.play();
    }

    public String play() {
        List<String> playerList = new ArrayList<String>();

        for (int x = 0; x < amountOfPlayers; x++) {
            playerList.add("Player " + (x+1));
        }

        for (int x = 0; x < playerList.size(); x++) {
            System.out.println(playerList.get(x));
        }

        return "Bitch";
    }

    public void rollDices() {
        diceFirst = dice1.roll();
        diceSecond = dice2.roll();
    }
}
