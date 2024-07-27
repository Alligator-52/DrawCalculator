package com.alligator.drawcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShuntingYard
{
    public static List<String> convertToRPN(String expression)
    {
        Stack<String> operators = new Stack<>();
        List<String> output = new ArrayList<>();

        for(int i = 0; i < expression.length(); i++)
        {
            char token = expression.charAt(i);

            if(Character.isDigit(token) || token == '.')
            {
                StringBuilder number = new StringBuilder();
                while(i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.'))
                {
                    number.append(expression.charAt(i++));
                }
                i--;
                output.add(number.toString());
            }
            else if (token == '(')
            {
                operators.push(String.valueOf(token));
            }
            else if (token == ')')
            {
                while(!operators.isEmpty() && !operators.peek().equals("("))
                {
                    output.add(operators.pop());
                }
            }
            else if(Character.isLetter(token))
            {
                StringBuilder operator = new StringBuilder();
                while(i < expression.length() && Character.isLetter(expression.charAt(i)))
                {
                    operator.append(expression.charAt(i++));
                }
                i--;

                String op = operator.toString();
                operator.setLength(0);
                if(Operator.isOperator(op) || Operator.isFunction(op))
                {
                    while(!operators.isEmpty() && Operator.isOperator(operators.peek()) &&
                            Operator.getPrecedence(op) <= Operator.getPrecedence(operators.peek()))
                    {
                        output.add(operators.pop());
                    }
                    operators.push((op));
                }
            }
            else if (Operator.isOperator(String.valueOf(token)))
            {
                while(!operators.isEmpty() && Operator.isOperator(operators.peek()) &&
                        Operator.getPrecedence(String.valueOf(token)) <= Operator.getPrecedence(operators.peek()))
                {
                    output.add(operators.pop());
                }
                operators.push(String.valueOf(token));
            }
        }

        while(!operators.isEmpty())
        {
            output.add(operators.pop());
        }

        return output;
    }

    public static double evaluateRPN(List<String> postfix)
    {
        Stack<Double> evalStack = new Stack<>();

        for (String token : postfix) {
            if (token.matches("\\d+(\\.\\d+)?")) {
                evalStack.push(Double.parseDouble(token));
            } else {
                if (Operator.isFunction(token)) {
                    double a = evalStack.pop();
                    switch (token) {
                        case "sin":
                            evalStack.push(Math.sin(a));
                            break;
                        case "cos":
                            evalStack.push(Math.cos(a));
                            break;
                        case "tan":
                            evalStack.push(Math.tan(a));
                            break;
                        case "log":
                            evalStack.push(Math.log(a));
                            break;
                        case "sqrt":
                            evalStack.push(Math.sqrt(a));
                            break;
                        case "asin":
                            evalStack.push(Math.asin(a));
                            break;
                        case "acos":
                            evalStack.push(Math.acos(a));
                            break;
                        case "atan":
                            evalStack.push(Math.atan(a));
                            break;
                    }
                } else {
                    double b = evalStack.pop();
                    double a = evalStack.pop();
                    switch (token) {
                        case "+":
                            evalStack.push(a + b);
                            break;
                        case "-":
                            evalStack.push(a - b);
                            break;
                        case "*":
                            evalStack.push(a * b);
                            break;
                        case "/":
                            evalStack.push(a / b);
                            break;
                        case "^":
                            evalStack.push(Math.pow(a, b));
                            break;
                    }
                }
            }
        }

        return evalStack.pop();

    }
}
