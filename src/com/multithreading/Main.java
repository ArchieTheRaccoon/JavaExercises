package com.multithreading;

public class Main
{
    private static boolean threadOneFinishedFirst = false;
    private static boolean threadTwoFinishedFirst = false;

    public static void main(String[] args)
    {
        GeneralBankManager.initialize();

        MyRunnableMatthes runnableMatthes = new MyRunnableMatthes();
        MyRunnableWeber runnableWeber = new MyRunnableWeber();

        Thread threadOne = new Thread(runnableMatthes);
        Thread threadTwo = new Thread(runnableWeber);

        threadOne.start();
        threadTwo.start();
    }

    public static boolean didThreadOneFinishedFirst() {
        return threadOneFinishedFirst;
    }

    public static boolean didThreadTwoFinishedFirst() {
        return threadTwoFinishedFirst;
    }

    public static void threadOneFinishedFirst() {
        threadOneFinishedFirst = true;
    }

    public static void threadTwoFinishedFirst() {
        threadTwoFinishedFirst = true;
    }
}
