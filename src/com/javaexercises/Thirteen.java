
package com.javaexercises;

import java.util.*;

public class Thirteen {
  public static void main(String[] Args) {
    List<String> classmatesArray = Arrays.asList("Gnar", "Elise", "Jinx", "Leona", "LeBlanc", "Sona", "Zoe", "Anivia", "Karma", "Zed", "Pyke", "Xerath", "Taric", "Pyke", "Leona");
    ArrayList<String> classmates = new ArrayList<String>(classmatesArray);
    Collections.sort(classmates);
    System.out.println(classmates);

    classmates.remove("LeBlanc");

    System.out.println("The size of the class is: " + classmates.size());

    List<String> whoWantPretzel = new ArrayList<String>();
    List<String> gotServed = new ArrayList<String>();

    for (int i = (classmates.size() - 1); i > ((classmates.size() - 1) - 5); i--) {
      whoWantPretzel.add(classmates.get(i));
    }

    Collections.shuffle(whoWantPretzel);

    for (int i = 0; i < 5; i++) {
      System.out.println(whoWantPretzel.get(i) + " is next on the line.");
      gotServed.add(whoWantPretzel.get(i));
    }

    int howManyDifferences = 0;

    for (int i = 0; i < 5; i++) {
      if (!whoWantPretzel.get(i).equals(gotServed.get(i))) {
        howManyDifferences++;
      }
    }
    boolean gotServedCheck = (howManyDifferences == 0);
    System.out.println("Everyone got served: " + gotServedCheck);

    List<String> dublicatedNames = new ArrayList<String>();
    int howManyCopys = 0;

    for (int i = 0; i < classmates.size(); i++) {
      for (String classmate : classmates) {
        if (classmates.get(i).equals(classmate)) {
          howManyCopys++;
          if (howManyCopys == 2 && !dublicatedNames.contains(classmates.get(i))) {
            dublicatedNames.add(classmates.get(i));
          }
        }
      }
      howManyCopys = 0;
    }
    System.out.println("Dublicated names: " + dublicatedNames);

    Map<String, String> phoneBook = new HashMap<String, String>();
    Thirteen thisClass = new Thirteen();

    for (String classmate : classmates) {
      phoneBook.put(classmate, thisClass.getRandomPhoneNumber().toString());
    }
    System.out.println("Gnar's number: " + phoneBook.get("Gnar"));
    System.out.println("Elise's number: " + phoneBook.get("Elise"));
    System.out.println("Zoe's number: " + phoneBook.get("Zoe"));
    System.out.println("Jinx's number: " + phoneBook.get("Jinx"));
    System.out.println("Leona's number: " + phoneBook.get("Leona"));
  }

  public StringBuilder getRandomPhoneNumber() {
    StringBuilder phoneNumber = new StringBuilder("+49");
    for (int i = 0; i < 11; i++) {
      phoneNumber.append(this.getRandomNumber());
    }
    return phoneNumber;
  }

  public int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(9);
  }
}
