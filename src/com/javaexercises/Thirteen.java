
package com.javaexercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    
  }
}
