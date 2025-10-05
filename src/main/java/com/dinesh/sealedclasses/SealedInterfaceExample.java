package com.dinesh.sealedclasses;

/**
 * Sealed interface expression
 */
sealed interface Expr
        permits ConstantExpr, PlusExpr, NegExpr {
    public int eval();
}

final class ConstantExpr implements Expr {
    int i;
    ConstantExpr(int i) { this.i = i; }
    public int eval() { return i; }
}

final class PlusExpr implements Expr {
    Expr a, b;
    PlusExpr(Expr a, Expr b) { this.a = a; this.b = b; }
    public int eval() { return a.eval() + b.eval(); }
}

final class NegExpr implements Expr {
    Expr e;
    NegExpr(Expr e) { this.e = e; }
    public int eval() { return -e.eval(); }
}
public class SealedInterfaceExample {

    public static void main(String[] args) {
        ConstantExpr constantExpr = new ConstantExpr(5);
        PlusExpr plusExpr = new PlusExpr(constantExpr, constantExpr);
        NegExpr negExpr = new NegExpr(plusExpr);

        System.out.println("------------------------------------------");

        System.out.println("Constant expression: " + constantExpr.eval());

        System.out.println("Plus expression: " + plusExpr.eval());

        System.out.println("Negative expression: " + negExpr.eval());

        System.out.println("-------------------------------------------");
    }
}
