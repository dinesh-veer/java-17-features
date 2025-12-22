package com.java17.trickyExamples;

public class VarWithLambda {
    public static void main(String[] args) {
        var limit = 10; 
        
        Runnable r = () -> {
             System.out.println(limit); // This works.
            // limit = 20; // ERROR: Local variable limit defined in an enclosing scope must be final
        };

        new Thread(r).start();
        // limit = 15;
        // If we uncomment the line above, the Lambda above will FAIL to compile 
        // because 'limit' is no longer "effectively final".
    }
}