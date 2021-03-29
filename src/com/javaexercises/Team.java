package com.javaexercises;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private final List<Player> players;
    private int goalCounter = 0;
    private int luckCounter = 0;

    public Team(String name, int playerCount) {
        this.name = name;

        int tempCount = 0;
        this.players = new ArrayList<>(playerCount);
        for (int x = 0; x < (playerCount - 1); x++) {
            this.players.add(new Player(this, "Player " + (x + 1), false));
            tempCount = x;
        }
        this.players.add(new Player(this, "Player " + (tempCount + 1), true));

    }

    public int getPlayerID(Player player) {
        return players.indexOf(player);
    }

    public Player getGoalkeeper() {
        int tempCount = 0;

        do {
            tempCount += 1;
        } while (!players.get(tempCount).isGoalkeeper());

        return players.get(tempCount);
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

    public int getLuckCounter() {
        return luckCounter;
    }

    public void setLuckCounter(int luckCounter) {
        this.luckCounter = luckCounter;
    }

    public void plusLuckCounter() {
        luckCounter += 1;
    }

    public void resetLuckCounter() {
        luckCounter = 0;
    }
}
