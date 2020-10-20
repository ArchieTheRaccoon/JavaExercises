
package com.javaexercises;

public class Eight {
  public static void main(String[] Args) {
    Integer[] numbers = { 11, 12, 13, 14, 15 };
    for (int i = 0; i < numbers.length; i++) {
      System.out.println("Number " + (i + 1) + " is " + numbers[i]);
    }
    Integer[] calenderDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    String[] daysOfWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
    int countDays = 1;

    for (int i = 0; i < calenderDays.length; i++) {
      for (int i1 = 0; i1 < calenderDays[i]; i1++) {
        if (countDays == 6) {
          countDays = 0;
        } else {
          countDays++;
        }
        System.out.println(daysOfWeek[countDays] + " " + (i1 + 1) + "." + (i + 1) + ".2020");
      }
    }
  }
}
