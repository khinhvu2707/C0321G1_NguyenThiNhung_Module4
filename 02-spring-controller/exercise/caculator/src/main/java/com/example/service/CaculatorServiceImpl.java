package com.example.service;

import com.example.exception.CalculateException;
import org.springframework.stereotype.Service;

@Service
public class CaculatorServiceImpl implements CaculatorService {
    @Override
    public String Calculate(float firstOperand, float secondOperand, String operator) {
        double resultNumber = 0;
        String resultString = "";
        try {
            if (operator.equals("+")) {
                resultNumber = firstOperand + secondOperand;
            } else if (operator.equals("-")) {
                resultNumber = firstOperand - secondOperand;
            } else if (operator.equals("*")) {
                resultNumber = firstOperand * secondOperand;
            } else {
                CalculateException.checkOperand(secondOperand);
                resultNumber = firstOperand / secondOperand;
            }
            resultString = (firstOperand + " " + operator + " " + secondOperand + " = " + resultNumber);
        } catch (Exception ex) {
            resultString = "Error: " + ex.getMessage();
        }
        return resultString;
    }
}
