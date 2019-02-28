package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String fileNmae = args[0];
//        String fileNmae = "/Users/mhlv/Documents/test1";
        TreeMap<Integer, Integer> map = new TreeMap<>();
        try (FileInputStream fis = new FileInputStream(fileNmae)) {
            while (fis.available() > 0) {
                int next = fis.read();
                if (map.containsKey(next)) {
                    map.put(next, map.get(next) + 1);
                } else map.put(next, 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println((char)entry.getKey().byteValue() + " " + entry.getValue());
        }
    }
}
