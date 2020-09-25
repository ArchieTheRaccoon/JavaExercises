package com.javaexercises;

public class two {
    public static void main(String[] Args) {
        float piNumber = (float) Math.PI;
        int firstNumberFromExercise = 4;
        int secondNumberFromExercise = 345;
        int thirdNumberFromExercise = 1000;
        float resultOfMath = (float) Math.pow(firstNumberFromExercise, 2) * secondNumberFromExercise;
        String resultOfMathString = String.valueOf(resultOfMath);
        float resultOfMathFloat = Float.parseFloat(resultOfMathString);
        float dividedResult = resultOfMathFloat / thirdNumberFromExercise;
        int resultOfMathInt = (int) dividedResult;
        System.out.println("First Step: " + resultOfMath + "\n" + "Second Step: " + resultOfMathString);
        System.out.println("Third Step: " + resultOfMathFloat + "\n" + "Fourth Step: " + dividedResult);
        System.out.println("Fifth Step: " + resultOfMathInt);
    }
}
