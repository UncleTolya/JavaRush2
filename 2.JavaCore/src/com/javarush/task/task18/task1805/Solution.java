package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        }
        Map<Integer, Integer> map = new TreeMap<>();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                int next = fis.read();
                if (map.keySet().contains(next)) {
                    map.put(next, map.get(next) + 1);
                } else map.put(next, 1);
            }
        }

//        int maxCount = map.values().stream().max(Integer::compareTo).get();
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == maxCount) System.out.print(entry.getKey() + " ");
//        }
        for (Integer integer : map.keySet()) {
            System.out.print(integer + " ");
        }

    }
}
