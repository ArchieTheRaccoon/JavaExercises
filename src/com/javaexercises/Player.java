package com.javaexercises;

public class Player {
    int teamIdOfThisPlayer;
    String nameOfThisPlayer;

    public Player(int teamIdOfThisPlayer, String nameOfThisPlayer) {
        this.teamIdOfThisPlayer = teamIdOfThisPlayer;
        this.nameOfThisPlayer = nameOfThisPlayer;
    }

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
