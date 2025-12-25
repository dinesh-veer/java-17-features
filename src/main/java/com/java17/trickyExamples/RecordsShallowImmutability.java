package com.java17.trickyExamples;

import java.util.ArrayList;
import java.util.List;

//this results into shallow immutability
//record Student(String name, List<String> grades) {}

//To make a record truly immutable, you must perform defensive copying in the constructor
record Student(String name, List<String> grades) {
    Student{
        grades = List.copyOf(grades);
    }
}

public class RecordsShallowImmutability {
    public static void main(String[] args) {
        List<String> myGrades = new ArrayList<>();
        myGrades.add("A");
        
        Student s = new Student("Alice", myGrades);
        System.out.println("Before: " + s.grades());

        // TRICK: The record is 'final', but the internal List is not!
        myGrades.add("B"); 
        
        System.out.println("After:  " + s.grades()); 
        // Output: [A, B] -> The "immutable" record changed!
    }
}