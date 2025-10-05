package com.dinesh.sealedclasses;

/**
 * If extending classes are declared in same class file
 * no need to use Permit clause.
 *
 * This example shows area example.
 * For reference, you can go to JEP 409
 * <p/>
 * Ref: <a href="https://openjdk.org/jeps/409">JEP 409</a>
 *
 */
sealed class Area{
}

final class Circle extends Area{

    public Double circleArea(Double radius){
        return Math.PI * Math.pow(radius, 2);
    }
}

final class Square extends Area{
    public Double squareArea(Double side){
        return side *  side;
    }
}


//If we try to define class as sealed but with no subclass
//it will give u compile time error as subclasses defined if nothing defined inside it
//sealed class Rectangle extends Area{}


non-sealed class Rectangle extends Area{
    public Double rectangleArea(Double length, Double width){
        return length * width;
    }
}

public class SealednSubclassInSameClass {

    public static void main(String[] args) {

        Circle circle = new Circle();
        Square square = new Square();
        Rectangle rectangle = new Rectangle();

        System.out.println("--------------------------------------------------------");

        System.out.println("Area of Circle having radius 5 :" + circle.circleArea(5.0));

        System.out.println("--------------------------------------------------------");

        System.out.println("Area of Square having side 13 :" + square.squareArea(13.0));

        System.out.println("--------------------------------------------------------");

        System.out.println("Area of Rectangle having length 8 and breadth 5 :" + rectangle.rectangleArea(8.0,5.0));

        System.out.println("------------------------------------------------------");


    }
}
