package com.javaexercises;

public class Seven {
        public static void main(String[] Args) {
            Seven thisClass = new Seven();
            thisClass.forLoops();
            thisClass.whileLoops();
            thisClass.doWhileLoops();
        }

        public void forLoops() {
            for (int i = 1; i <= 1000; i++) {
                System.out.println(i);
            }

            for (double i = 222; i <= 1111; i++) {
                if (i / i == i % 2) {
                    System.out.println(i);
                }
            }

            for (double i = 222; i <= 1111; i++) {
                if (i / 2 == (int)(i / 2)) {
                    System.out.println(i);
                }
            }
        }

        public void whileLoops() {
            int rollsNeeded = 1;
            int firstDice;
            int secondDice;

            while (true) {
                firstDice = (int)((Math.random() * 6) + 1);
                secondDice = (int)((Math.random() * 6) + 1);
                if (firstDice == 6 && secondDice == 6) {
                    break;
                } else {
                    rollsNeeded++;
                }
            }

            System.out.println("Both sides of 2 Dices are at 6. Counted times: " + rollsNeeded);
        }

        public void doWhileLoops() {
            int rollsNeeded = 1;
            int firstDice;
            int secondDice;

            do {
                firstDice = (int)((Math.random() * 6) + 1);
                secondDice = (int)((Math.random() * 6) + 1);
                if (firstDice == 6 && secondDice == 6) {
                    break;
                } else {
                    rollsNeeded++;
                }
            } while (rollsNeeded < 100 + 1);

            System.out.println("Both sides of 2 Dices are at 6. Counted times: " + rollsNeeded);
        }
}
