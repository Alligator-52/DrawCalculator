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
                
            }
        }
    }
}
