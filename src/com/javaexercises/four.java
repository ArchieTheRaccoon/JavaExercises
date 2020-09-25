package com.javaexercises;

public class four {
    public static void main(String[] Args) {
        float speedOfLight = 1_080_000_000;
        float distanceBetweenSunAndEarth = 149_600_000;
        float timeNeededForLightFromSunToEarth = distanceBetweenSunAndEarth / speedOfLight;
        int timeInMinutes = (int) (timeNeededForLightFromSunToEarth * 60);
        System.out.println("It takes about ~" + timeInMinutes + " Minutes for light to travel from Sun to Earth.");
    }
}
