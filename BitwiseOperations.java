package com.example.gitdemo.Calculate;

/**
 * Yalnızca programcı hesap makinesinin ihtiyaç duyduğu bit düzeyi işlemler.
 */
public interface BitwiseOperations {

    int and(int a, int b);
    int or(int a, int b);
    int xor(int a, int b);
}
