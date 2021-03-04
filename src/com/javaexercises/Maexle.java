package com.javaexercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Maexle {
    Dice dice1;
    Dice dice2;

    int amountOfPlayers = 0;
    int playerID = 0;
    List<Integer> pasheNumbers = new ArrayList<>();
    List<Integer> normalNumbers = new ArrayList<>();
    int maexleNumber = 21;
    boolean firstGame = true;

    public Maexle(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
        dice1 = new Dice(6);
        dice2 = new Dice(6);
    }

    public static void main(String[] Args) {
        Maexle maexle = new Maexle(3);
        maexle.initializeNumbers();
        maexle.play();
    }

    public String play() {
        List<String> playerList = new ArrayList<String>();

        ////////////////////////////////////////////// Creating a List with Players
        for (int x = 0; x < amountOfPlayers; x++) {
            playerList.add("Player " + (x+1));
        }
        //////////////////////////////////////////////

        int PL1dice1 = 0;
        int PL1dice2 = 0;

        if (firstGame) {
            System.out.println(playerList.get(this.playerID) + " rolls a dice.");
            PL1dice1 = getRolledDice1();
            PL1dice2 = getRolledDice2();
            System.out.println("His number is " + processNumbers(PL1dice1, PL1dice2));
        }

        int player1numbers = processNumbers(PL1dice1, PL1dice2);

        nextPlayer();

        System.out.println(playerList.get(this.playerID) + " rolls a dice.");
        justRollDices();
        System.out.println("His number is " + processNumbers(dice1.getSum(), dice2.getSum()));

        int player2numbers = processNumbers(dice1.getSum(), dice2.getSum());

        boolean PL2numbersAreBigger = false;

        if (player1numbers == maexleNumber) {
            if (player2numbers == maexleNumber) {
                PL2numbersAreBigger = false;
            } else {
                PL2numbersAreBigger = false;
            }
        } else if (pasheNumbers.contains(player1numbers)) { //when PL1Numbers are Pashe
            if (pasheNumbers.contains(player2numbers)) { //when PL2Numbers are Pashe as well
                if (player2numbers > player1numbers) { //when PL2 Pashe number is bigger than PL1 Pashe numbers
                    PL2numbersAreBigger = true;
                } else {
                    PL2numbersAreBigger = false;
                }

            } else if (player2numbers == maexleNumber) { //when PL2 numbers are maexle number
                PL2numbersAreBigger = true;
            } else { //when everything else
                PL2numbersAreBigger = false;
            }
        } else if (normalNumbers.contains(player1numbers)) { //when PL1 numbers are normal numbers
            if (pasheNumbers.contains(player2numbers)) { //when PL2 numbers are pashe numbers
                PL2numbersAreBigger = true;
            } else if (player2numbers == maexleNumber) { //when PL2 numbers are maexle number
                PL2numbersAreBigger = true;
            } else if (normalNumbers.contains(player2numbers)) { //when PL2 numbers are normal numbers
                if (player2numbers > player1numbers) { //when PL2 numbers are bigger than PL1 numbers
                    PL2numbersAreBigger = true;
                } else {
                    PL2numbersAreBigger = false;
                }
            }
        }

        if (player1numbers == player2numbers) {
            PL2numbersAreBigger = false;
        }

        if (PL2numbersAreBigger) {
            System.out.println(playerList.get(this.playerID) + " won this round.");
        } else {
            System.out.println(playerList.get(this.playerID - 1) + " won this round.");
        }


        return "Bitch"; // need to change it later
    }

    public void nextPlayer() {
        playerID++;
        if (playerID > amountOfPlayers) {
            playerID = 0;
        }
    }

    public void justRollDices() {
        dice1.reset();
        dice2.reset();

        dice1.roll();
        dice1.sum();

        dice2.roll();
        dice2.sum();
    }

    public int getRolledDice1() {
        dice1.roll();
        dice1.sum();
        return dice1.getSum();
    }

    public int getRolledDice2() {
        dice2.roll();
        dice2.sum();
        return dice2.getSum();
    }

    public int processNumbers(int dice1, int dice2) {
        String processedNumbers = "";

        if (dice1 == dice2) {
            processedNumbers = String.valueOf(dice1) + dice2;
        } else if (dice1 > dice2) {
            processedNumbers = String.valueOf(dice1) + dice2;
        } else {
            processedNumbers = String.valueOf(dice2) + dice1;
        }

        return Integer.parseInt(processedNumbers);
    }

    public void initializeNumbers() {
        this.pasheNumbers = Arrays.asList(11, 22, 33, 44, 55, 66);
        this.normalNumbers = Arrays.asList(21, 31, 41, 51, 61, 32, 42, 52, 62, 43, 53, 63, 54, 64, 65);
    }
}
