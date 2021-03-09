package com.javaexercises;

import java.util.*;

public class SoccerMatch {
    int playTime = 165;
    int stoppageTime = 5;
    int amountOfPlayersPerTeam = 11;

    int howManyTeamsArePlaying;
    boolean areSubstitutesAllowed;
    Player ballLocation;

    int teamID = 0;
    int playerID = 0;
    int opponentTeamID = 0;
    int opponentPlayerID = 0;

    Random random = new Random();

    public void play() {
        howManyTeamsArePlaying = 2;
        areSubstitutesAllowed = false;

        List<Team> teamList = new ArrayList<>(howManyTeamsArePlaying);
        List<Player> playerList = new ArrayList<>((amountOfPlayersPerTeam * howManyTeamsArePlaying));

        for (int x = 0; x < howManyTeamsArePlaying; x++) {
            teamList.add(new Team("Team " + (x + 1), amountOfPlayersPerTeam));
        }

        teamID = chooseRandomTeam(teamList);
        playerID = chooseRandomPlayerFromTeam(teamList.get(teamID));
        ballLocation = teamList.get(teamID).getPlayers().get(playerID);

        opponentTeamID = nextTeam();
        opponentPlayerID = chooseRandomPlayerFromTeam(teamList.get(nextTeam()));


        while (playTime > 0) {

            int action = firstTeamAction(teamList); // team action
//            boolean tempActionSuccess = random.nextInt(2) == 0;
            boolean firstTeamProbabilityTestSuccess = probabilityTest(teamList, teamID, playerID);


            int opponentsAction = opponentTeamAction(teamList, action); // opponents action
//            boolean tempOpponentActionSuccess = random.nextInt(2) == 0;
            boolean opponentTeamProbabilityTestSuccess = probabilityTest(teamList, opponentTeamID, opponentPlayerID);


            if (firstTeamProbabilityTestSuccess) {
                if (action == 1) {
                    if (opponentTeamProbabilityTestSuccess) {
                        if (opponentsAction == 1) {
                            //
                        } else if (opponentsAction == 2) {
                            ballLocation = teamList.get(opponentTeamID).getPlayers().get(opponentPlayerID);
                        }
                    }
                }
            }

            playTime -= 1;
        }
    }

    public boolean probabilityTest(List<Team> teamList, int methodTeamID, int methodPlayerID) {
        int tempRandom = random.nextInt(100);

        return teamList.get(methodTeamID).getPlayers().get(methodPlayerID).getPercentageChance() < tempRandom;
    }

    public int firstTeamAction(List<Team> teamList) {
        int tempRandomizer = random.nextInt(100);

        if (tempRandomizer < 70) {               // 70% chance

            return teamList.get(teamID).getPlayers().get(playerID).A2();

        } else if (tempRandomizer < 90) {       // 20% chance

            return teamList.get(teamID).getPlayers().get(playerID).A3();

        } else {                                // 10% chance

            return teamList.get(teamID).getPlayers().get(playerID).A1();

        }
    }

    public int opponentTeamAction(List<Team> teamList, int action) {

        if (action == 1) {

            int tempRandom = random.nextInt(2);

            if (tempRandom == 0) {
                return teamList.get(opponentTeamID).getPlayers().get(opponentPlayerID).B1a();
            } else {
                return teamList.get(opponentTeamID).getPlayers().get(opponentPlayerID).B1b();
            }


        } else if (action == 2) {

            return teamList.get(opponentTeamID).getPlayers().get(opponentPlayerID).B2();

        } else {

            return teamList.get(opponentTeamID).getPlayers().get(opponentPlayerID).B3();

        }

    }

    public int nextTeam() {
        if (teamID >= (howManyTeamsArePlaying - 1)) {
            return 0;
        }
        return (teamID + 1);
    }

    public int chooseRandomTeam(List<Team> teamList) {
        return random.nextInt(teamList.size());
    }

    public int chooseRandomPlayerFromTeam(Team team) {
        return random.nextInt(team.getPlayers().size());
    }

    public static void main(String[] Args) {
        SoccerMatch sm = new SoccerMatch();
        sm.play();
    }
}
