package com.javaexercises;

public class Player {
    int teamIdOfThisPlayer;
    String nameOfThisPlayer;

    public Player(int teamIdOfThisPlayer, String nameOfThisPlayer) {
        this.teamIdOfThisPlayer = teamIdOfThisPlayer;
        this.nameOfThisPlayer = nameOfThisPlayer;
    }

    //---------------------------------------------------------------------

    public void A1() { // try to score a goal
        //here should be code
    }

    public void A2() { // pass the ball to other player
        //here should be code
    }

    public void A3() { //dribble to position
        //here should be code
    }

    //---------------------------------------------------------------------

    public void B1a() { //block the ball (outfield player)
        //here should be code
    }

    public void B1b() { //catch the ball (goalkeeper)
        //here should be code
    }

    public void B2() { //catch the ball (outfield player)
        //here should be code
    }

    public void B3() { //straddle the opposing player
        //here should be code
    }

    //----------------------------------------------------------------------

    public int getTeamIdOfThisPlayer() {
        return teamIdOfThisPlayer;
    }

    public void setTeamIdOfThisPlayer(int teamIdOfThisPlayer) {
        this.teamIdOfThisPlayer = teamIdOfThisPlayer;
    }

    public String getNameOfThisPlayer() {
        return nameOfThisPlayer;
    }

    public void setNameOfThisPlayer(String nameOfThisPlayer) {
        this.nameOfThisPlayer = nameOfThisPlayer;
    }
}
