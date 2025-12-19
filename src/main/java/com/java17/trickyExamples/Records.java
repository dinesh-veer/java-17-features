package com.java17.trickyExamples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

record Person(String name, List<String> skills) {}
//Every non-canonical constructor in a record must delegate to the canonical constructor.
//record Point(int x, int y) {
//    public Point(int x) {//Compile time error
//        this.x = x;   // ❌ not allowed
//    }
//}

//We can override equals method in Records
record Book(String title) {
    @Override
    public boolean equals(Object o) {
        return true;
    }
}

//Records implicitly extend java.lang.Record.
//They cannot extend other classes, only implement interfaces.
class A {}
//record B() extends A {} //error: records cannot extend other classes


//Records can implement interfaces
interface Identifiable {
    int id();
}
record User(int id) implements Identifiable {}

//Records with static fields
//❌ No instance fields
//✅ Static fields allowed
record Counter(int x) {
    static int count = 0;
}

//Compile time error :Instance field is not allowed in record
//record Bad(int x) {
//    int y = 10;
//}

record R(int x, int y) {}

record UserInfo(String name) implements Serializable {
    static int id;
}


//Records are final
record A1(int x) {}
//class B extends A1 {}//Compile time error : Records are implicitly final.


record Data(int[] arr) {}

//DeepCopy
record SafeData(int[] arr) {
    SafeData {
        arr = arr.clone();
    }
}
//✔ Makes record deeply immutable.

/**
“Records are transparent carriers of immutable state with shallow
immutability, structural equality, and restricted extensibility.”
 **/
public class Records {

    public static void main(String[] args) {

        System.out.println("-----------------------------------------");
        /**
         * Records are shallowly immutable:
         * Fields are final
         * But mutable objects inside can still change
         *
         * ✔ Interview phrase:
         *
         * “Records guarantee shallow immutability, not deep immutability.”
         */
        List<String> skills = new ArrayList<>();
        skills.add("Java");

        Person p = new Person("Dinesh", skills);
        skills.add("Spring");

        System.out.println(p.skills());

        System.out.println("-----------------------------------------");

        System.out.println("Records Can Implement Interfaces");
        Identifiable identifiable = new User(1);
        System.out.println("User id: " + identifiable.id());

        System.out.println("-----------------------------------------");

        System.out.println("Records with static fields");
        Counter counter = new Counter(1);

        System.out.println("Counter x: " + counter.x());
        System.out.println("-----------------------------------------");

        System.out.println("Compare two Records");

        //All components participate in equals, hashCode, and toString.
        System.out.println("new R(1,3).equals(new R(1,2)) " +new R(1,3).equals(new R(1,2)));
        System.out.println("new R(1,3).equals(new R(1,2)) " +new R(1,3).equals(new R(1,3)));

        System.out.println("-----------------------------------------");

        //Serialization includes only Records Components
        //Custom fields (static or computed) are NOT serialized.
        System.out.println("Record Serialization");
        UserInfo u = new UserInfo("A");

        System.out.println("User Information: " + u);

        System.out.println("-----------------------------------------");

        int[] a = {1,2};
        Data d = new Data(a);
        a[0] = 99;

        System.out.println(d.arr()[0]);// 99: will be output

        System.out.println("----------------------------------------");


    }
}
