package com.javaexercises;

import java.util.*;

public class SoccerMatch {
    int playTime = 165;
    int stoppageTime = 5;
    int amountOfPlayersPerTeam = 11;

    int howManyTeamsArePlaying;
    boolean areSubstitutesAllowed;
    int ballLocation;

    int teamID = 0;
    int playerID = 0;
    int opponentTeamID = 0;
    int opponentPlayerID = 0;

    Random random = new Random();

    public void play() {
        howManyTeamsArePlaying = 2;
        areSubstitutesAllowed = false;


        Map<Integer, String> teamsList = new HashMap<>();
        Map<Integer, Player> playersList = new HashMap<>();

        List<Team> teamList = new ArrayList<>(howManyTeamsArePlaying);
        List<Player> playerList = new ArrayList<>((amountOfPlayersPerTeam * howManyTeamsArePlaying));

        for (int x = 0; x < howManyTeamsArePlaying; x++) {
//            teamsList.put(x, "Team " + (x + 1));
            teamList.add(new Team("Team " + (x + 1), amountOfPlayersPerTeam));
        }

        chooseRandomTeam();
        chooseRandomPlayerFromCurrentTeam(playersList);
        ballLocation = playerID;

        while (playTime > 0) {
            int tempRandomizer = random.nextInt(100);

            if (tempRandomizer < 70) {               // 70% chance

                playersList.get(playerID).A1();

            } else if (tempRandomizer < 90) {       // 20% chance

                playersList.get(playerID).A2();

            } else {                                // 10% chance

                playersList.get(playerID).A3();

            }

            playTime -= 1;
        }
    }

    public int nextTeam() {
        if (teamID > howManyTeamsArePlaying) {
            return 0;
        }
        return (teamID + 1);
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
