package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream console = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);
        testString.printSomething();
        String newString = bos.toString();
        System.setOut(console);
        try(FileOutputStream fis = new FileOutputStream(fileName)) {
            ByteArrayInputStream bis = new ByteArrayInputStream(newString.getBytes());
            while (bis.available() > 0) {
                fis.write(bis.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(newString);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

