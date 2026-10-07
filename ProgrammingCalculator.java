package com.example.gitdemo.Calculate;

public class ProgrammingCalculator implements ArithmeticOperations, BitwiseOperations {

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
    public int and(int a, int b) {
        return a & b;
    }

    @Override
    public int or(int a, int b) {
        return a | b;
    }

    @Override
    public int xor(int a, int b) {
        return a ^ b;
    }
}
