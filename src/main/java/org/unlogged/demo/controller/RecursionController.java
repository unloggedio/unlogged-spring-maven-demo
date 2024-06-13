package org.unlogged.demo.controller;

public class RecursionController {

    private int factorial(int n) {
        if (n != 0) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

    public int getFactorialOfNumber(int number) {
        return factorial(number);
    }

    private int fibonacci(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public int getFibonacciSeries(int number) {
        return fibonacci(number);
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        return false;
    }

    public boolean getIsPalindrome(String input) {
        return isPalindrome(input);
    }
}
