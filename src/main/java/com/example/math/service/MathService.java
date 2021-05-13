package com.example.math.service;

import java.util.List;
import java.util.stream.Collectors;

public class MathService {

    public static String getSum(List<Object> valueList) {

        int answer = 0;
        String response = "";

        answer = valueList.stream().mapToInt(i -> Integer.valueOf((String) i)).sum();
        response = valueList.stream().map(s -> s.toString()).collect(Collectors.joining(" + "));

        response += " = " + answer;
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
