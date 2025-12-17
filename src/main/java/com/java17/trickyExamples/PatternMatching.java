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


        //if (object instanceof String s || s.length() > 10) { // ❌ Compile error : s is undefined
        //    System.out.println("Condition passed for string: " + s);
        //}
            // Pattern binding through || is unsafe:
            //If first condition fails → s does not exist.
            //Therefore, Java disallows the second operand using s.

        Object o = "Java";
        //Pattern variable doent exists only in the negative branch:
        if (!(o instanceof String s)) {
            // s NOT in scope
           // System.out.println(s);  // ❌ Compile-time error: s is undefined
        }

        //Pattern variable exists only in the positive branch:
        if( o instanceof String s) {
            System.out.println("Value inside if " + s);
        }

        //Assignment expression
        if ( (o instanceof String s) == true ) {
            //System.out.println(s);  //❌ Compile-time error: s is undefined
        }
        //The expression is evaluated as:
        //(obj instanceof String s) produces a boolean
        //That boolean is compared to true
        //The scope of s does not escape outside the instanceof
        //Thus s is not in scope.


        System.out.println("---------------------------------------------");

    }
}
