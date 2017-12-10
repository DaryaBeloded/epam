package com.company.entity;

import com.company.parse.Parser;

/**
 * Created by Dasha on 21.10.2017.
 */
public class Calculator {
    private String expression;

    public Calculator(String expression) {
        this.expression = expression;
    }


    public Double calculate() {
        String[] arr = Parser.parse(expression);
        if (arr == null) {
            return null;
        }
        double a1 = Double.parseDouble(arr[0]);
        double a2 = Double.parseDouble(arr[1]);
        switch (Parser.getSignFromString(expression)) {
            case "+":
                return a1 + a2;
            case "-":
                return a1 - a2;
            case "*":
                return a1 * a2;
            case "/": {
                if (a2 != 0) {
                    return a1 / a2;
                } else
                    return null;
            }
            default:
                return null;
        }
    }

}
