package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String fileName = "/Users/mhlv/Documents/test1";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<Integer, Integer> map = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                int next = fis.read();
                if (map.keySet().contains(next)) {
                    map.put(next, map.get(next) + 1);
                } else map.put(next, 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (map.keySet().contains(44)) System.out.println(map.get(44));
    }
}
