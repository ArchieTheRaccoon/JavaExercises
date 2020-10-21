package com.javaexercises;

import java.util.Random;

public class Fourteen {
    public int indicator = 0;

    public enum Color {
        RED, GREEN, BLUE, BLACK, WHITE, ORANGE, YELLOW;
    }

    Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public void whatIThinkAbout() {
        switch (color) {
            case ORANGE:
                System.out.println("Yeeeeah my favourite color!");
                break;
            case YELLOW:
                System.out.println("Buhhh i hate this color!");
                break;
            default:
                System.out.println("This color is ok.");
                break;
        }
    }

    public Color getRandomColor() {
        Random random = new Random();
        this.indicator = random.nextInt(Color.values().length);
        return Color.values()[indicator];
    }

    public static void main(String[] Args) {
        Fourteen thisClass = new Fourteen();
        System.out.println(Color.BLACK + " " + Color.ORANGE);

        thisClass.setColor(thisClass.getRandomColor());
        System.out.println("Random color: " + Color.values()[thisClass.indicator]);
        thisClass.whatIThinkAbout();
    }
}
