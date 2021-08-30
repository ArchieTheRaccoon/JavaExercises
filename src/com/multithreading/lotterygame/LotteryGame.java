package com.multithreading.lotterygame;

import java.util.*;

public class LotteryGame {
    private final static int ballCount = 49;
    private final static int ballFalloutCount = 7;
    private static boolean doContinue = true;

    private static ArrayList<Ball> ballRunnables = new ArrayList<>();
    private static ArrayList<Thread> ballThreads = new ArrayList<>();
    private static List<Ball> falledBalls = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {

        for (int x = 0; x < ballCount; x++) {
            ballRunnables.add(new Ball(x + 1));
        }

        Collections.shuffle(ballRunnables, new Random());

        for (int x = 0; x < ballFalloutCount; x++) {
            ballRunnables.get(x).setChanceBooster(20);
        }

        for (int x = 0; x < ballCount; x++) {
            ballThreads.add(new Thread(ballRunnables.get(x)));
        }

        ballThreads.forEach(thread -> thread.start());

        falledBalls.forEach(balls -> System.out.println(balls.getBallNumber()));
    }

    public static void addFalledBall(Ball ball) {
        if (falledBalls.size() < ballFalloutCount && ball.getContinueLoop() && doContinue) {
            ball.setContinueLoop(false);
            falledBalls.add(ball);
        } else {
            doContinue = false;
            ballRunnables.forEach(balls -> balls.setContinueLoop(false));
        }
    }

    public static int getBallCount() {
        return ballCount;
    }
}
