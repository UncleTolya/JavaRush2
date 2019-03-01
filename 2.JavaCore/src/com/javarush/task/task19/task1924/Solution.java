package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }
    public static void main(String[] args) {
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                String s = br.readLine();
                s = changeDigit(s);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String changeDigit(String input) {
        String answer = input;
        for (Map.Entry<Integer, String> digitEntry : map.entrySet()) {
//            System.out.println(digitEntry.getKey() + " " + digitEntry.getValue());
            Pattern pattern = Pattern.compile("\\b(" + digitEntry.getKey() + ")\\b");
            Matcher matcher = pattern.matcher(answer);
            if (matcher.find()) {
                answer = matcher.replaceAll(digitEntry.getValue());
            }
//            System.out.println(answer);
        }

        return answer;
    }
}
