package com.dinesh.record;

/**
 * Records remove boilerplate for DTOs:
 * constructor, accessors, equals, hashCode, and toString are auto‑generated.
 * They’re ideal for immutable data.
 *<p>
 * Reference:
 * <a href="https://openjdk.org/jeps/395">Open JDK Records documentation </a>
 *<p>
 * <a href="https://docs.oracle.com/en/java/javase/17/language/records.html">Oracle Records reference</a>
 *
 */
record UserInformation(Integer id, String name, Integer age){
    UserInformation{
        if(age<0){
            throw new IllegalArgumentException("Age must be greater than or equal to 0");
        }
    }
}


public class RecordExample {

    public static void main(String[] args) {
        UserInformation userInformation = new UserInformation(1, "Dinesh",10);

        System.out.println(userInformation);

        //This will throw IllegalArgumentException
        UserInformation userInformation1 = new UserInformation(2, "Dinesh",-10);
        System.out.println(userInformation1);

    }
}

/*

record Point(int x, int y){}

//above declaration is similar to below once
record Point(int x, int y){
    //implicitly declared variables
    private final int x;
    private final int y;

    //implicit declared constructor
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //other implicit methods
}*/

//Records doesn't support extends clause
