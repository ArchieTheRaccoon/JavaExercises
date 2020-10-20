
package com.javaexercises;

import java.util.Random;

public class Ten {
  public static void main(String[] Args) {
    Ten thisClass = new Ten();
    thisClass.draw5RandomPipes();
  }

  public int randomNumber() {
    Random random = new Random();
    return random.nextInt((35 - 5) + 1) + 5;
  }

  public void draw5RandomPipes() {
    Ten thisClass = new Ten();
    StringBuilder printingSpikes = new StringBuilder();

    for (int i = 0; i < 5; i++) {
      for (int i1 = 0; i1 < thisClass.randomNumber(); i1++) {
        printingSpikes.append("|");
      }
      System.out.println(printingSpikes);
      printingSpikes.delete(0, printingSpikes.length());
    }
  }
}
