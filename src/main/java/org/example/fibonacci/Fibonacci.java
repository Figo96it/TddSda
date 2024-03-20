package org.example.fibonacci;

public class Fibonacci {

    public static int calculateFibonacci(int element) {
        if (element == 0 || element == 1) {
            return element;
        }

        return calculateFibonacci(element - 2) + calculateFibonacci(element - 1);
    }
}

