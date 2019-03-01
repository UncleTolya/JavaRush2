package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
//        String fileName = "/Users/mhlv/Documents/test3 copy";
        TreeMap<String, Double> map = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                String next = br.readLine();
                String secondName = next.trim().split("\\s+")[0];
                Double value = Double.parseDouble(next.trim().split("\\s+")[1]);
                if (map.keySet().contains(secondName)) {
                    map.put(secondName, map.get(secondName) + value);
                } else {
                    map.put(secondName, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        double maxValue = Double.MIN_VALUE;

//        for (Map.Entry<String, Double> stringDoubleEntry : map.entrySet()) {
//            if (stringDoubleEntry.getValue() > maxValue) maxValue = stringDoubleEntry.getValue();
//        }
//        for (Map.Entry<String, Double> stringDoubleEntry : map.entrySet()) {
//            if (stringDoubleEntry.getValue() == maxValue)
//                System.out.println(stringDoubleEntry.getKey());
//        }
        for (Map.Entry<String, Double> stringDoubleEntry : map.entrySet()) {
            System.out.println(stringDoubleEntry.getKey() + " " + stringDoubleEntry.getValue());
        }
    }
}
