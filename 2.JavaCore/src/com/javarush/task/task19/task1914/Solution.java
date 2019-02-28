package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);
        testString.printSomething();
        String newString = primer(bos.toString());
        System.setOut(console);
        System.out.println(newString);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

    public static String primer(String input) {
        String answer = "";
        return input + getAndMakeOperation(input);
    }

    public static int getFirstArgument(String input) {
        String num1 = input.split("\\D+")[0];
        return Integer.parseInt(num1);
    }

    public static int getSecondArgument(String input) {
        String num2 = input.split("\\D+")[1];
        return Integer.parseInt(num2);
    }

    public static Integer getAndMakeOperation(String input) {
        String oper = input.replaceAll("[\\s\\d=]" ,"");
        switch (oper) {
            case "*" : return getFirstArgument(input) * getSecondArgument(input);
            case "+" : return getFirstArgument(input) + getSecondArgument(input);
            case "-" : return getFirstArgument(input) - getSecondArgument(input);
            default: return null;
        }

    }


}

