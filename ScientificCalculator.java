package com.example.gitdemo.Calculate;

public class ScientificCalculator implements ArithmeticOperations, ScientificOperations {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        return a / b;
    }

    @Override
    public double sqrt(double number) {
        return Math.sqrt(number);
    }

    @Override
    public double log(double number) {
        return Math.log10(number);
    }

    @Override
    public double sin(double number) {
        return Math.sin(number);
    }

    @Override
    public double cos(double number) {
        return Math.cos(number);
    }
}
