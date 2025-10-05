package com.dinesh.sealedclasses;

sealed interface Expression
        permits ConstantExpresion, PlusExpresion, NegExpresion {
    public int eval();
}

record ConstantExpresion(int i) implements Expression {
    public int eval() { return i(); }
}

record PlusExpresion(Expression left, Expression right) implements Expression {
    public int eval() { return left.eval() + right.eval(); }
}

record NegExpresion(Expression left) implements Expression {
    public int eval() { return -left.eval(); }
}

public class RecordAsSubClass {

    public static void main(String[] args) {

        Double d = 20.0;
        synchronized (d) { System.out.println("ttttt"); } // javac warning & HotSpot warning
        Object o = d;
        synchronized (o) { System.out.println("tets"); } // HotSpot warning

        ConstantExpresion constantExpresion = new ConstantExpresion(5);
        PlusExpresion plusExpresion = new PlusExpresion(constantExpresion, constantExpresion);
        NegExpresion negExpresion = new NegExpresion(constantExpresion);

        System.out.println("------------------------------------------");

        System.out.println("Constant Expression for value 5 :" + constantExpresion.eval());

        System.out.println("Plus Expression for value 5 and 5 :" + plusExpresion.eval());

        System.out.println("Negation Expression for value 5 :" + negExpresion.eval());

        System.out.println("-------------------------------------------");
    }


}
