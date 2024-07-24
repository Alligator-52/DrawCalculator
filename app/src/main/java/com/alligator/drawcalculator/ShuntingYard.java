package com.alligator.drawcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShuntingYard
{
    public static void convertToRPN(String expression)
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
            else
            {
                StringBuilder operator = new StringBuilder();
                while(i < expression.length() && Character.isLetter(expression.charAt(i)))
                {
                    operator.append(expression.charAt(i++));
                }
                i--;

                String op = operator.toString();
            }
        }
    }
}
