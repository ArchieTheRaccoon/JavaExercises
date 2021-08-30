package com.multithreading.lotterygame;

import java.util.Random;

public class Ball implements Runnable{
    private final int ballNumber;
    private int chanceBooster = 0;
    private boolean continueLoop = true;
    Random random = new Random();

    public Ball(int ballNumber){
        this.ballNumber = ballNumber;
    }

    @Override
    public void run() {
        int limiter = 1;

        if (chanceBooster > 0) {
            limiter += (LotteryGame.getBallCount() / 100) * chanceBooster;
        }

        while (continueLoop) {
            int tempRandom = random.nextInt(LotteryGame.getBallCount());

            if (tempRandom < limiter) {
                LotteryGame.addFalledBall(this);
                break;
            }
        }
    }

    public void setChanceBooster(int boostPercentage) {
        chanceBooster = boostPercentage;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public void setContinueLoop(boolean continueLoop) {
        this.continueLoop = continueLoop;
    }

    public boolean getContinueLoop() {
        return continueLoop;
    }
}
