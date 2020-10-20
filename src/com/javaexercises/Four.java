
package com.javaexercises;

public class Four {
  public static void main(String[] Args) {
    float speedOfLight = 1_080_000_000;
    float distanceBetweenSunAndEarth = 149_600_000;
    byte secondsInMinute = 60;
    float timeNeededForLightFromSunToEarth = distanceBetweenSunAndEarth / speedOfLight;
    float timeInMinutes = timeNeededForLightFromSunToEarth * secondsInMinute;
    float timeInSeconds = (timeInMinutes - (int) timeInMinutes) * secondsInMinute;
    System.out.println("It takes about " + (int) timeInMinutes + " Minutes and " + (int) timeInSeconds + " Seconds for light to travel from Sun to Earth.");
  }
}
