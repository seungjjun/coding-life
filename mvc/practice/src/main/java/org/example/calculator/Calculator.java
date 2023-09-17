package org.example.calculator;

public class Calculator {
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return ArithmeticOperator.calculate(operand1, operator, operand2);
    }
}
