package com.java17.trickyExamples;

public class SwitchYield {
    public static void main(String[] args) {
        int day = 60;

        String type = switch (day) {
            case 6, 7 -> "Weekend";
            case 1, 2, 3, 4, 5 -> "Weekday";
            default -> {
                yield "Invalid"; // must use yield in block-style
            }                   //without block gives you compile time error as not a statement.
        };

        System.out.println(type); // Weekend
    }
}
