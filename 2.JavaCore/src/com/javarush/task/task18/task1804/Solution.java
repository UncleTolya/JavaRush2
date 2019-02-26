package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        }
        Map<Integer, Integer> map = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                int next = fis.read();
                if (map.keySet().contains(next)) {
                    map.put(next, map.get(next) + 1);
                } else map.put(next, 1);
            }
        }

        int minCount = map.values().stream().min(Integer::compareTo).get();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == minCount) System.out.print(entry.getKey() + " ");
        }

    }
}
