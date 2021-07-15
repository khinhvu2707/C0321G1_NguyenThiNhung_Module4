package com.example.repository;

public class CalculateException {
    public static void checkOperand(float secondOperand) throws Exception {
        if (secondOperand == 0) {
            throw new Exception("Can't divide by zero");
        }
    }
}
