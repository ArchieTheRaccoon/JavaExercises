package com.javaexercises;

import java.util.*;


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
        System.out.println("The winner of this game is " + maexle.play());
        System.out.println("||||||||||||||||||||||||||||||||||||");
    }

    public String play() {
        Map<Integer, Integer> amountOfLives = new HashMap<>();
        Map<Integer, String> mapPlayerList = new HashMap<>();
        List<Integer> playersAlive = new ArrayList<Integer>();
        int updatingAmountOfPlayers = amountOfPlayers;
        int PL1dice1 = 0;
        int PL1dice2 = 0;

        int player1numbers = 0;

        for (int x = 0; x < updatingAmountOfPlayers; x++) {
            amountOfLives.put(x, 3);
            playersAlive.add(x);
        }

        for (int x = 0; x < updatingAmountOfPlayers; x++) {
            mapPlayerList.put(x, "Player " + (x+1));
        }

        if (firstGame) {
            System.out.println(mapPlayerList.get(playerID) + " rolls a dice.");
            PL1dice1 = getRolledDice1();
            PL1dice2 = getRolledDice2();
            System.out.println("His number is " + processNumbers(PL1dice1, PL1dice2));
        }

        while (mapPlayerList.size() > 1) {  //the engine of this game?
            player1numbers = processNumbers(PL1dice1, PL1dice2);

            nextPlayer();
            while (!mapPlayerList.containsKey(playerID)) {
                nextPlayer();
            }

            System.out.println("--------------------------------");
            System.out.println(mapPlayerList.get(playerID) + " rolls a dice.");
            justRollDices();
            System.out.print("Live count: ");
            for (int x = 0; amountOfLives.get(playerID) > x; x++) {
                System.out.print("❤");
            }
            System.out.println();
            System.out.println("His number is " + processNumbers(dice1.getSum(), dice2.getSum()));
            System.out.println("--------------------------------");

            int player2numbers = processNumbers(dice1.getSum(), dice2.getSum());

            boolean PL2numbersAreBigger = isPL2winning(player1numbers, player2numbers);

            if (PL2numbersAreBigger) {
                System.out.println(mapPlayerList.get(playerID) + " won this round.");
            } else {
                System.out.println("Current player didn't outbid the last biggest number.");
                amountOfLives.put(playerID, amountOfLives.get(playerID) - 1);

                if (amountOfLives.get(playerID) < 1) {
                    mapPlayerList.remove(playerID);
                }
            }

            if (mapPlayerList.size() == 1) {
                System.out.println("||||||||||||||||||||||||||||||||||||");

                int tempCountOfPlayerID = playerID;
                while (!mapPlayerList.containsKey(tempCountOfPlayerID)) {
                    tempCountOfPlayerID++;
                }
                return mapPlayerList.get(playersAlive.get(tempCountOfPlayerID));
            }

            PL1dice1 = dice1.getSum();
            PL1dice2 = dice2.getSum();
        }

        System.out.println("--------------------------------");
        return mapPlayerList.get(playerID);
    }

    public boolean isPL2winning(int player1numbers, int player2numbers) {
        boolean PL2isWinning = false;
        if (player1numbers == maexleNumber) { //when both PL1 and PL2 numbers are maexle, PL2 numbers arent bigger
            if (player2numbers == maexleNumber) {
                PL2isWinning = false;
            } else {
                PL2isWinning = false;
            }
        } else if (pasheNumbers.contains(player1numbers)) { //when PL1Numbers are Pashe
            if (pasheNumbers.contains(player2numbers)) { //when PL2Numbers are Pashe as well
                if (player2numbers > player1numbers) { //when PL2 Pashe number is bigger than PL1 Pashe numbers
                    PL2isWinning = true;
                } else {
                    PL2isWinning = false;
                }

            } else if (player2numbers == maexleNumber) { //when PL2 numbers are maexle number
                PL2isWinning = true;
            } else { //when everything else
                PL2isWinning = false;
            }
        } else if (normalNumbers.contains(player1numbers)) { //when PL1 numbers are normal numbers
            if (pasheNumbers.contains(player2numbers)) { //when PL2 numbers are pashe numbers
                PL2isWinning = true;
            } else if (player2numbers == maexleNumber) { //when PL2 numbers are maexle number
                PL2isWinning = true;
            } else if (normalNumbers.contains(player2numbers)) { //when PL2 numbers are normal numbers
                if (player2numbers > player1numbers) { //when PL2 numbers are bigger than PL1 numbers
                    PL2isWinning = true;
                } else {
                    PL2isWinning = false;
                }
            }
        }

        if (player1numbers == player2numbers) {
            PL2isWinning = false;
        }

        return PL2isWinning;
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
