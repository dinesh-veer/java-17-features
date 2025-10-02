package com.dinesh.record.innerRecord;

import com.dinesh.record.innerRecord.rec.*;

public class PackageRecordsExample {

    public static void main(String[] args) {
        //if You explicitly doesnt specify the Record in import till you will get compile time error
        //java: reference to Record is ambiguous

        //  both class com.dinesh.record.innerRecord.rec.Record in
        //  com.dinesh.record.innerRecord.rec and class java.lang.Record in java.lang match
        //Record record = new Record("Welcome");

    }
}
