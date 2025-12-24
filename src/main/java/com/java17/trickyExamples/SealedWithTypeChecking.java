package com.java17.trickyExamples;

public class SealedWithTypeChecking {
    sealed interface Shape permits Circle, Square {}
    
    final record Circle(double radius) implements Shape {}
    final record Square(double side) implements Shape {}

    public static void main(String[] args) {
        Shape shape = new Circle(5.0);
        
        // Tricky: No 'default' case is needed here because it's sealed.
        // What if we added a 'permits' entry but didn't cover it in switch?
        String result = switch (shape) {
            case Circle c -> "Circle with area: " + (Math.PI * c.radius() * c.radius());
            case Square s -> "Square with area: " + (s.side() * s.side());
            // The compiler knows no other subtypes exist.
        };
        System.out.println(result);
    }
}