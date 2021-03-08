package com.javaexercises;

import java.util.HashMap;
import java.util.Map;

public class SoccerMatch {
    int playTime = 165;
    int stoppageTime = 5;
    int amountOfPlayersPerTeam = 11;
    int teamID = 0;
    int howManyTeamsArePlaying;
    boolean areSubstitutesAllowed;
    boolean firstGame = true;

    public void play() {
        howManyTeamsArePlaying = 2;
        areSubstitutesAllowed = false;

        Map<Integer, String> teamsList = new HashMap<>();

        for (int x = 0; x < howManyTeamsArePlaying; x++) {
            teamsList.put(x, "Team " + x);
        }

        if (firstGame) {

        }
    }

    public static void main(String[] Args) {
        SoccerMatch sm = new SoccerMatch();
        sm.play();
    }
}
