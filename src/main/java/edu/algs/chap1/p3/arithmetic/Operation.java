package edu.algs.chap1.p3.arithmetic;

import java.util.function.BiFunction;

enum Operation {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULT("*", (a, b) -> a * b),
    DIV("/", (a, b) -> {
        if (b != 0) {
            return a / b;
        } else {
            throw new IllegalArgumentException("cannot divide by 0");
        }
    });

    private String symbol;
    private BiFunction<Double, Double, Double> function;

    Operation(String s, BiFunction<Double, Double, Double> f) {
        symbol = s;
        function = f;
    }

    double apply(double a, double b) {
        return function.apply(a, b);
    }

    static Operation fromString(String s) {
        for (Operation op : Operation.values()) {
            if (op.symbol.equals(s)) {
                return op;
            }
        }
        throw new IllegalArgumentException("No such operation supported: " + s);
    }

    static boolean isOperation(String s) {
        for (Operation op : Operation.values()) {
            if (op.symbol.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
