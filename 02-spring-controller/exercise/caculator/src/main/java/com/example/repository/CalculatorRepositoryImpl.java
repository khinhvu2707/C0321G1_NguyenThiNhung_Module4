package com.example.repository;

import com.example.Exception.CalculateException;
import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepositoryImpl implements CaculatorRepository {
    @Override
    public String Calculate(float firstOperand, float secondOperand, String operator) {
        double resultNumber = 0;
        String resultString = "";
        try {
            CalculateException.checkOperand(secondOperand);
            if (operator.equals("+")) {
                resultNumber = firstOperand + secondOperand;
            } else if (operator.equals("-")) {
                resultNumber = firstOperand - secondOperand;

            } else if (operator.equals("*")) {
                resultNumber = firstOperand * secondOperand;

            } else {
                resultNumber = firstOperand / secondOperand;

            }
            resultString = (firstOperand + " " + operator + " " + secondOperand + " = " + resultNumber);
        } catch (Exception ex) {
            resultString = "Error: " + ex.getMessage();
        }
        return resultString;
    }
}
