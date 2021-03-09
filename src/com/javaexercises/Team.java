package com.javaexercises;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private final List<Player> players;
    private int goalCounter = 0;

    public Team(String name, int playerCount) {
        this.name = name;

        this.players = new ArrayList<>(playerCount);
        for (int x = 0; x < playerCount; x++) {
            this.players.add(new Player(this, "Player " + (x + 1)));
        }
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }


    public int getGoalCounter() {
        return goalCounter;
    }

    public void setGoalCounter(int goalCounter) {
        this.goalCounter = goalCounter;
    }

    public void plusOneGoal() {
        this.goalCounter += 1;
    }
}
