package com.alligator.drawcalculator;

import java.util.HashMap;
import java.util.Map;

public class Operator
{
    private static final Map<String, Integer> _precedenceMap = new HashMap<>();
    static
    {
        _precedenceMap.put("+", 1);
        _precedenceMap.put("-", 1);
        _precedenceMap.put("*", 2);
        _precedenceMap.put("/", 2);
        _precedenceMap.put("%", 2);
        _precedenceMap.put("^", 3);
        _precedenceMap.put("sin", 4);
        _precedenceMap.put("cos", 4);
        _precedenceMap.put("tan", 4);
        _precedenceMap.put("log", 4);
        _precedenceMap.put("sqrt", 4);
        _precedenceMap.put("asin", 4);
        _precedenceMap.put("acos", 4);
        _precedenceMap.put("atan", 4);
    }

    public static boolean isOperator(String token)
    {
        return _precedenceMap.containsKey(token);
    }

    public static int getPrecedence(String operator)
    {
        if(!_precedenceMap.containsKey(operator)) return 0;
        return _precedenceMap.get(operator);
    }

    public static boolean isFunction(String token)
    {
        return token.equals("sin") || token.equals("cos") || token.equals("tan") ||
                token.equals("log") || token.equals("sqrt") || token.equals("asin") ||
                token.equals("acos") || token.equals("atan");
    }
}
