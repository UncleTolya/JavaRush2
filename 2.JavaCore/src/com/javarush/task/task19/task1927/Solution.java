package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream newConsole = new PrintStream(bos);
        System.setOut(newConsole);
        testString.printSomething();
        System.setOut(console);
        String[] lines = bos.toString().split(System.lineSeparator());
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
            if (i % 2 != 0) System.out.println("JavaRush - курсы Java онлайн");
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
