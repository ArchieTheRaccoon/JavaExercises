package com.javaexercises;

import java.util.*;

public class SoccerMatch {
    int playTime = 165;
    int stoppageTime = 5;
    int amountOfPlayersPerTeam = 11;

    int howManyTeamsArePlaying;
    boolean areSubstitutesAllowed;
    Player ballLocation;

    int teamID = -1;
    int playerID = -1;
    int opponentTeamID = -1;
    int opponentPlayerID = -1;

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
        playerID = chooseRandomPlayerFromTeam(teamList.get(teamID), playerID);
        ballLocation = teamList.get(teamID).getPlayers().get(playerID);

        opponentTeamID = nextTeam();
        opponentPlayerID = chooseRandomPlayerFromTeam(teamList.get(nextTeam()), opponentPlayerID);


        while (playTime > 0) {

            int action = firstTeamAction(teamList); // team action
//            boolean tempActionSuccess = random.nextInt(2) == 0;
//            boolean firstTeamProbabilityTestSuccess = probabilityTest(teamList, teamID, playerID);



            int opponentsAction = opponentTeamAction(teamList, action); // opponents action

            if (action == 1) {
                if (probabilityTest(teamList, teamID, playerID, true)) {
                    if (probabilityTest(teamList, opponentTeamID, opponentPlayerID, false)) {
                       if (opponentsAction == 2) {
                           ballLocation = teamList.get(opponentTeamID).getPlayers().get(opponentPlayerID);
                       }
                    } else {
                        teamList.get(teamID).plusOneGoal();
                        ballLocation = teamList.get(opponentTeamID).getPlayers().get(chooseRandomPlayerFromTeam(teamList.get(opponentTeamID), -1));
                    }
                } else {
                    if (probabilityTest(teamList, opponentTeamID, opponentPlayerID, false)) {
                        if (opponentsAction == 2) {
                            ballLocation = teamList.get(opponentTeamID).getPlayers().get(opponentPlayerID);
                        }
                    }
                }
            } else if (action == 2) {
                if (probabilityTest(teamList, teamID, playerID, false)) {
                    if (probabilityTest(teamList, opponentTeamID, opponentPlayerID, false)) {
                        ballLocation = teamList.get(opponentTeamID).getPlayers().get(opponentPlayerID);
                    } else {
                        ballLocation = teamList.get(teamID).getPlayers().get(chooseRandomPlayerFromTeam(teamList.get(teamID), playerID));
                    }
                } else {
                    if (probabilityTest(teamList, opponentTeamID, opponentPlayerID, false)) {
                        ballLocation = teamList.get(opponentTeamID).getPlayers().get(opponentPlayerID);
                    }
                }
            } else if (action == 3) {
                if (probabilityTest(teamList, teamID, playerID, false)) {
                    if (probabilityTest(teamList, opponentTeamID, opponentPlayerID, false)) {
                        ballLocation = getRandomPlayerFromField(teamList, teamID, opponentTeamID);
                    } else {
                        teamList.get(teamID).plusLuckCounter();
                    }
                } else {
                    if (probabilityTest(teamList, opponentTeamID, opponentPlayerID, false)) {
                        ballLocation = getRandomPlayerFromField(teamList, teamID, opponentTeamID);
                    }
                }
            }

            teamID = whoHasKickOffNext(teamList, ballLocation);
            playerID = teamList.get(teamID).getPlayers().indexOf(ballLocation);

            playTime -= 1;
        }
    }

    public int whoHasKickOffNext(List<Team> teamList, Player ballLocation) {
        return teamList.indexOf(ballLocation.getTeam());
    }

    public Player getRandomPlayerFromField(List<Team> teamList, int teamID, int opponentTeamID) {
        int tempRandom = random.nextInt(2);

        if (tempRandom == 1) {
            return teamList.get(teamID).getPlayers().get(random.nextInt(teamList.get(teamID).getPlayers().size()));
        } else {
            return teamList.get(opponentTeamID).getPlayers().get(random.nextInt(teamList.get(opponentTeamID).getPlayers().size()));
        }
    }

    public boolean probabilityTest(List<Team> teamList, int methodTeamID, int methodPlayerID, boolean forGoal) {
        Dice dice = new Dice(100);
        dice.roll();
        dice.sum();
        int luckNumber = dice.getSum();

        if (forGoal) {

            int numberToSucceed = (
                    teamList.get(methodTeamID).getPlayers().get(methodPlayerID).getPercentageChance() +
                            (
                                    teamList.get(methodTeamID).getLuckCounter() *
                                            (
                                                    (
                                                            teamList.get(methodTeamID).getPlayers().get(methodPlayerID).getPercentageChance() / 100
                                                    ) * 5
                                            )
                            )
            );

            return luckNumber <= numberToSucceed;

        } else {
            return luckNumber <= teamList.get(methodTeamID).getPlayers().get(methodPlayerID).getPercentageChance();
        }
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

            if (tempRandom == 1) {
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

    public int chooseRandomPlayerFromTeam(Team team, int ID) {
        int tempCount;

        do {
            tempCount = random.nextInt(team.getPlayers().size());
        } while (random.nextInt(team.getPlayers().size()) == ID);

        return tempCount;
    }

    public static void main(String[] Args) {
        SoccerMatch sm = new SoccerMatch();
        sm.play();
    }
}
