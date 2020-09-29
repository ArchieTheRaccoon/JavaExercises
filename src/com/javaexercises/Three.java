package com.javaexercises;

public class Three {
    public static void main(String[] Args) {
        float lengthOfTriangleA = 10;
        float lengthOfTriangleB = 10;
        float lengthOfTriangleC = 10;
        float inHalfTiling = 2;
        double halfSize = (lengthOfTriangleA + lengthOfTriangleB + lengthOfTriangleC) / inHalfTiling;
        double areaOfTriangle = Math.sqrt(
                halfSize *
                (halfSize - lengthOfTriangleA) *
                (halfSize - lengthOfTriangleB) *
                (halfSize - lengthOfTriangleC));

        if (areaOfTriangle > 0) {
            System.out.println("Area of this Triangle is " + (float)areaOfTriangle + ".");
        } else {
            System.out.println("The Area for this Triangle does not exist.");
        }
    }
}
