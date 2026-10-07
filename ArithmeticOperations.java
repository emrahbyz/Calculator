package com.example.gitdemo.Calculate;

/**
 * Tüm hesap makinelerinin ortak ihtiyacı olan dört temel işlem.
 */
public interface ArithmeticOperations {

    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}
