package com.dinesh.patternMatching;

/**
 * This is new switch case example in which we don't have to use break
 * also we don't need to use return statement using lambda expression it will work.
 * Below example check given number is less than, equal to or greater than 10.
 * yield is used to return the value in block
 * <p>
 * Ref: <a href="https://openjdk.org/jeps/361">JEP-361 Referecnce</a>
 *
 */
public class SwitchExamples {

    static String LESS_THAN_10= "Number is less than 10";
    static String GREATER_THAN_10= "Number is greater than 10";
    static String EQUAL_TO_10= "Number is equal to 10";


    public static String getNumber(int number){
    return switch(number){
            case 1,2,3,4,5,6,7,8,9 -> LESS_THAN_10;
            case 10 -> EQUAL_TO_10;
            default -> {
                System.out.println("Entered number is out of range :" + number );
                yield GREATER_THAN_10;
            }
        };
    }



    public static void main(String[] args) {
        System.out.println("------------------------------------------------------");

        System.out.println("7 is less than 10 : " + getNumber(7) );

        System.out.println("18 is greater than 10 : " + getNumber(18) );

        System.out.println("10 is equal to 10 : " + getNumber(10) );

        System.out.println("--------------------------------------------------------");

    }
}
