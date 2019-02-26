package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самые частые байты
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
//        TreeMap<Integer, Integer> sortByValuesMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, TreeMap::new));
//        Map.Entry<Integer, Integer> entry = sortByValuesMap.pollLastEntry();
//        int max = entry.getValue();
//        while (entry != null && entry.getValue() == max) {
//            System.out.print(entry.getKey() + " ");
//            entry = sortByValuesMap.pollLastEntry();
//
//        }
        int maxCount = map.values().stream().max(Integer::compareTo).get();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) System.out.print(entry.getKey() + " ");
        }

    }
}
