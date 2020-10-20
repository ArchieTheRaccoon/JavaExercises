
package com.javaexercises;

import java.util.Random;

public class Eleven {
  public static void main(String[] Args) {
    Eleven thisClass = new Eleven();
    System.out.println(thisClass.getRandomString());
  }

  public StringBuilder getRandomString() {
    String alphabet = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
    String[] alphabetArray = alphabet.split(",");
    String numbers = "0,1,2,3,4,5,6,7,8,9";
    String[] numbersArray = numbers.split(",");

    Eleven thisClass = new Eleven();
    StringBuilder randomLettersAndNumbers = new StringBuilder();
    for (int i = 0; i < thisClass.randomNumber(); i++) {
      boolean trueOrFalse = 0 == thisClass.randomNumberFalseTrue();
      if (trueOrFalse) {
        randomLettersAndNumbers.append(alphabetArray[thisClass.randomNumberFromArray(alphabetArray.length)]);
      } else {
        randomLettersAndNumbers.append(numbersArray[thisClass.randomNumberFromArray(numbersArray.length)]);
      }
    }
    return randomLettersAndNumbers;
  }

  public int randomNumber() {
    Random random = new Random();
    return random.nextInt(100);
  }

  public int randomNumberFalseTrue() {
    Random random = new Random();
    return random.nextInt(2) - 1;
  }

  public int randomNumberFromArray(int length) {
    Random random = new Random();
    return random.nextInt(length);
  }
}
