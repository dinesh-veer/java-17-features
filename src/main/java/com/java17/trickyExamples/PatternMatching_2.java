package com.java17.trickyExamples;

public class PatternMatching_2 {

    public static void main(String[] args) {

        System.out.println("---------------------------------------------");
        System.out.println("instanceof always true");

         Object string = "Java 17";

         //This will always be true because everything is an Object.
         //if IDE is giving error run through cmd
//        if (string instanceof Object o) {
//            System.out.println(o);
//        }

        System.out.println("---------------------------------------------");
        System.out.println("Confusing flow ....");
        Object o = 123;

        if (!(o instanceof String s) || s.length() > 2) {
            System.out.println("Hi");// Prints "Hi"
        }

        Object another ="123";
        if (!(another instanceof String s) || s.length() > 2) {
            System.out.println("Hi");//Prints "Hi" as another condition is satisfied
        }

        System.out.println("---------------------------------------------");

        System.out.println("Pattern matching in Ternary Operators");
        Object java = "Java17";
        String result = (java instanceof String s) ? s.toUpperCase() : "Not a string";
        System.out.println(result);
        //Pattern variables are in scope only in the true branch of ? :.
        System.out.println("--------------------------------------------");

        System.out.println("Pattern matching with final variable");

        if (java instanceof final String s) {
            System.out.println(s);// we cant reassign value to s as it is final one
        }

        System.out.println("---------------------------------------------");

        System.out.println("Scope vanishing");
        Object scope = "Java";

        //var is not supported
        //if (scope instanceof var s) {}
        if (scope instanceof String s) {
            scope = 10;
            System.out.println(s.length());   // 4 (length of string
        }
        System.out.println("Value if scope variable "+ scope);// 10 (print reassigned value)

        System.out.println("--------------------------------------------");

        System.out.println("Check the object");
        test("1111");
        test(2222);

        System.out.println("--------------------------------------------");

    }

    static void test(Object o) {
        //The compiler proves that after the return, execution continues only if the pattern matched.
        if (!(o instanceof String s)) {
            return;
        }
        System.out.println(s.toUpperCase());  // ?
    }


}
