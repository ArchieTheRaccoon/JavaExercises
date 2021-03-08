package com.javaexercises;

import java.util.*;

public class SoccerMatch {
    int playTime = 165;
    int stoppageTime = 5;
    int amountOfPlayersPerTeam = 11;
    int teamID = 0;
    int playerID = 0;
    int howManyTeamsArePlaying;
    boolean areSubstitutesAllowed;

    Random random = new Random();

    public void play() {
        howManyTeamsArePlaying = 2;
        areSubstitutesAllowed = false;


        Map<Integer, String> teamsList = new HashMap<>();
        Map<Integer, Player> playersList = new HashMap<>();

        int tempCounter = 0;
        for (int x = 0; x < howManyTeamsArePlaying; x++) {
            teamsList.put(x, "Team " + (x + 1));

            for (int y = 0; y < amountOfPlayersPerTeam; y++) {
                playersList.put(tempCounter, new Player(x, "Player " + (tempCounter + 1)));
                tempCounter += 1;
            }
        }

        chooseRandomTeam();
        chooseRandomPlayerFromCurrentTeam(playersList);

        System.out.println(teamsList.get(teamID));
        System.out.println(playersList.get(playerID).getNameOfThisPlayer());
    }

    public void chooseRandomTeam() {
        teamID = random.nextInt(howManyTeamsArePlaying);
    }

    public void chooseRandomPlayerFromCurrentTeam(Map<Integer, Player> playersList) {
        int tempIDForPlayer;

        do {
            tempIDForPlayer = random.nextInt(playersList.size());

        } while ((playersList.get(tempIDForPlayer).getTeamIdOfThisPlayer() != teamID));

        playerID = tempIDForPlayer;
    }

    public static void main(String[] Args) {
        SoccerMatch sm = new SoccerMatch();
        sm.play();
    }
}
