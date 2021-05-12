package com.example.math.service;

import java.util.List;

public class MathService {

    public static String getSum(List<Object> valueList) {

        int answer = 0;
        String response = "";

        for (Object i : valueList) {
            response += i.toString() + " + ";
            answer += Integer.valueOf((String) i);
        }
        response = response.substring(0, response.length() - 2);
        response += "= " + answer;
        return response;
    }

    public static String getCalculateAnswer(String operation, int x, int y) {
        int answer = 0;
        String op = "";

        switch (operation) {
            case "add":
                op = " + ";
                answer = x + y;
                break;
            case "multiply":
                op = " * ";
                answer = x * y;
                break;
            case "subtract":
                op = " - ";
                answer = x - y;
                break;
            case "divide":
                op = " / ";
                answer = x / y;
                break;
            default:
                op = " + ";
                answer = x + y;
                break;
        }
        String response = "" + x + op + y + " = " + answer;
        return response;
    }
}
