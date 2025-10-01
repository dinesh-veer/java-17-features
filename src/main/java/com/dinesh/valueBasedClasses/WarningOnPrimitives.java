package com.dinesh.valueBasedClasses;

/**
 * Preemitive constructore for value assignation are deprecated from java 9
 * But from java 16 it will give you compile time warning.
 * <p></p>
 * To resolve this issue it is suggested to use static factory method <b><i>valueOf</i></b> method.
 *<p></p>
 * Also for synchronisation gives warning based(compile time or Hotspot) upon static typing
 * <p>
 * </p>
 * Reference : <a href="https://openjdk.org/jeps/390">JEP 390</a>
 */
public class WarningOnPrimitives {

    public static void main(String[] args) {
        //Below code gives compile time warning as
        //constructors for Primitives are deprecated and marked for removal

        Byte byteValue = new Byte("1");
        Short shortValue = new Short((short) 4);
        Long longVale = new Long(99);
        Double twenty = new Double("20");
        Integer integer = new Integer(11);
        Boolean booleanValue = new Boolean(true);
        Float floatValue = new Float(10.0f);
        Character charValue = new Character('c');

        //To Resolve above warning it is suggested to use static factory valueOf method
        Byte byteValueOf =  Byte.valueOf("1");
        Short shortValueOf =  Short.valueOf((short) 4);
        Long longValeOf =  Long.valueOf(99);
        Double twentyOf = Double.valueOf("20");
        Integer integerOf = Integer.valueOf(11);
        Boolean booleanValueOf = Boolean.valueOf("true");
        Float floatValueOf = Float.valueOf(10.0f);
        Character charValueOf =  Character.valueOf('c');


        Double d = 20.0;
        synchronized (d) {// javac warning & HotSpot warning
            System.out.println(d);
        }
        Object o = d;
        synchronized (o) { // HotSpot warning
            System.out.println(o);
        }

    }
}
