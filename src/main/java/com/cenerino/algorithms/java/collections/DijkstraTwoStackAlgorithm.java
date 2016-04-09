package com.cenerino.algorithms.java.collections;

public class DijkstraTwoStackAlgorithm {

    public double eval(String[] expression) {
        LinkedStack<Double> vals = new LinkedStack<>();
        LinkedStack<String> opers = new LinkedStack<>();

        for (String el : expression) {
            if (el.equals("("))
                continue;

            if (el.matches("[*+]")) {
                opers.push(el);
                continue;
            }

            if (el.equals(")")) {
                String oper = opers.pop();

                if (oper.equals("+"))
                    vals.push(vals.pop() + vals.pop());
                else
                    vals.push(vals.pop() * vals.pop());

                continue;
            }

            vals.push(Double.valueOf(el));
        }

        return vals.pop();
    }
}
