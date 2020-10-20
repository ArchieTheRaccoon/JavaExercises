
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

  }
}
