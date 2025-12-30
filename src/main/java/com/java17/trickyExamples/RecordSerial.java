package com.java17.trickyExamples;

import java.io.*;

record Range(int start, int end) implements Serializable {
    // Compact Constructor with validation
    public Range {
        if (start > end) {
            throw new IllegalArgumentException("Start must be before end!");
        }
    }
}

public class RecordSerial {
    public static void main(String[] args) throws Exception {
        // Imagine we maliciously craft a byte stream where start=100 and end=50.
        // In a normal Class, readObject() would create the object anyway.
        // In a Record, it MUST call the canonical constructor.
        Range range = new Range(100, 50);
        // This will THROW an InvalidObjectException because validation is enforced.
    }
}