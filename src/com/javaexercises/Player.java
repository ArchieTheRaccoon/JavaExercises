package com.javaexercises;

import java.util.Random;

public class Player {
    private final Team team;
    private final String nameOfThisPlayer;
    private final int percentageChance;
    private final boolean isGoalkeeper;
    Random random = new Random();


    public Player(Team team, String nameOfThisPlayer, boolean isGoalkeeper) {
        this.team = team;
        this.nameOfThisPlayer = nameOfThisPlayer;
        this.isGoalkeeper = isGoalkeeper;
        this.percentageChance = random.nextInt((50 - 25) + 1) + 25;
    }

    public boolean isGoalkeeper() {
        return isGoalkeeper;
    }

    //---------------------------------------------------------------------

    public int A1() { // try to score a goal
        return 1;
        //here should be code
    }

    public int A2() { // pass the ball to other player
        return 2;
        //here should be code
    }

    public int A3() { //dribble to position
        return 3;
        //here should be code
    }

    //---------------------------------------------------------------------

    public int B1a() { //block the ball (outfield player)
        return 1;
    }

    public int B1b() { //catch the ball (goalkeeper)
        return 2;
    }

    public int B2() { //catch the ball (outfield player)
        return 3;
    }

    public int B3() { //straddle the opposing player
        return 4;
    }

    //----------------------------------------------------------------------


    public int getPercentageChance() {
        return percentageChance;
    }

    public Team getTeam() {
        return team;
    }

    public String getNameOfThisPlayer() {
        return nameOfThisPlayer;
    }
}
