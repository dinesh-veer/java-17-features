package com.java17.trickyExamples;

public class PatternMatching {

    public static void main(String[] args) {

        System.out.println("---------------------------------------------");

        Object object = "This is java 17 example";

        //The scope of string variable is limited to if block only
        if (object instanceof String string && string.length() > 10)
            System.out.println("Condition passed for string: " + string);
        //Below code will give us compile time error
        //System.out.println("Condition passed for string: " + string); //❌ Compile error: string not visible here

        Object variable = "Java 17 example";

        if (object instanceof String s) {
            //String s = "chnage version";//❌ Compile error : s is already declared in scope
            s = "another value assigned"; // We can assign value to local variable
            System.out.println("Value inside if " + s);
        }
        System.out.println("Value of outside if " + object);

        System.out.println("---------------------------------------------");

    }
}
