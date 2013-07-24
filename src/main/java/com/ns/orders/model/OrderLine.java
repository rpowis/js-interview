package com.ns.orders.model;

public class OrderLine {
    private int lineNumber;
    private double lineValue;

    public OrderLine(int lineNumber, double lineValue) {
        this.lineNumber = lineNumber;
        this.lineValue = lineValue;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public double getLineValue() {
        return lineValue;
    }
}
