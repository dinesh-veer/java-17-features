package com.dinesh.instaceof;

/**
 *This is example of instanceof of pattern matching.
 * In this example it will give us the information about
 * changes in one as explicit conversion not needed anymore.
 * Also multiple conditions can added into operation with &&.
 * <p>
 *Ref:<a href="https://openjdk.org/jeps/394">JEP-394: Instanceof</a>
 */
public class InstanceOfExamples {

    public static boolean validateObject(Object o) {
        return o instanceof String;
        //older version to convert
/*
        if (obj instanceof String) {
            String s = (String) obj;
        }
*/
    }

    public static boolean checkJDKInString(Object obj){
        boolean result = false;
        //we can add multiple condition with && only after type check
        if (obj instanceof String s && s.length() > 5) {
            result = s.contains("JDK");
        }

        //Below code will give u compile time error as str is not defined not accessible in second
        //condition
       /* if (obj instanceof String str || str.length() > 5) {
            result = str.contains("JDK");
        }*/


        return result;
    }

    public static void main(String[] args) {

        String jdkExample = "This is JDK example";

        Integer number = 100;
        System.out.println("------------------------------------------------------");

        //Validate given object is of string type
        System.out.println("Given jdkExample object is of String type : "+validateObject(jdkExample));

        System.out.println("Given number object is of Integer type : "+validateObject(number));

        System.out.println("--------------------------------------------------------");

    }

}
