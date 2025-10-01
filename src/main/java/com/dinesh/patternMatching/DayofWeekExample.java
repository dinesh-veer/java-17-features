package com.dinesh.patternMatching;

/**
 * This is new switch case example in which we don't have to use break
 * also we don't need to use return statement using lambda expression it will work.
 * Below example shows based upon day it is which type of day Weekday or Weekend.
 * <p>
 * Ref: <a href="https://openjdk.org/jeps/361">JEP-361 Referecnce</a>
 * <a href="https://docs.oracle.com/en/java/javase/17/language/pattern-matching.html">Oracle Reference </a>
 *
 */
public class DayofWeekExample {

    public enum DayOfWeek {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
    }

    public enum TypeofDay{
        Weekday, Weekend, Unknown
    }

    public static TypeofDay getTypeofDay(DayOfWeek dayOfWeek){
       return switch (dayOfWeek){
            case Monday, Tuesday, Wednesday, Thursday, Friday -> TypeofDay.Weekday;
            case Saturday, Sunday -> TypeofDay.Weekend;
        };
    }



    public static TypeofDay getTypeofDayOldWay(DayOfWeek dayOfWeek){
        TypeofDay typeofDay = TypeofDay.Unknown;
        switch (dayOfWeek){
            case Monday:
            case Tuesday:
            case Wednesday:
            case Thursday:
            case Friday:
                typeofDay = TypeofDay.Weekday;
                break;
            case Saturday:
            case Sunday:
                typeofDay = TypeofDay.Weekend;
                break;
        }
        return typeofDay;

    }

    //Inner variable declaration with assignation n compile time error
    /**
    public static int get(String day){
         switch (day) {
            case "MONDAY":
            case "TUESDAY":
                int temp = 100;     // The scope of 'temp' continues to the }
                System.out.println(temp);
                break;
            case "WEDNESDAY":
            case "THURSDAY":
                int temp2 = temp;    // Can't call this variable 'temp'
                System.out.println(temp2);
                break;
            default:
                int temp3 = temp; // Can't call this variable 'temp'
        };
    }*/

public static void main(String[] args) {

    System.out.println("------------------------------------------------------");

    System.out.println("Get the Type of Day for Thursday using old switch style : "+ getTypeofDayOldWay(DayOfWeek.Thursday));

    System.out.println("-------------------------------------------------------");

    System.out.println("Get the Type of Day for Sunday using new switch style : "+ getTypeofDay(DayOfWeek.Sunday));

    System.out.println("-------------------------------------------------------");


}
}
