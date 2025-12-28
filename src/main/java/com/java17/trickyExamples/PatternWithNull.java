package com.java17.trickyExamples;

public class PatternWithNull {
    /**
     * If you remove the case null, the code reverts to the old behavior and throws a NullPointerException at the switch line.
     * Java 17 allows you to handle null as a specific case within the switch logic for the first time.
     * @param obj
     */
    public static void test(Object obj) {
        switch (obj) {
            case String s && s.length() > 5 -> System.out.println("Long String");
            case String s -> System.out.println("Short String");
            case Integer i -> System.out.println("Integer");
            case null -> System.out.println("Found a null!"); // New in Java 17+
            default -> System.out.println("Unknown type");
        }
    }

    /**
     * Prior to Java 17, switch statements threw a NullPointerException immediately if the selector was null.
     * With Pattern Matching, the behavior is more nuanced.
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        test(null);
    }
}