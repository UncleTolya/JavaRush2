package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName;
            while (!(fileName = br.readLine()).equals("exit")) {
               Thread thread = new ReadThread(fileName);
               thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(resultMap);

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            TreeMap<Integer, Integer> map = new TreeMap<>();

            try (FileInputStream fis = new FileInputStream(fileName)) {
                while (fis.available() > 0) {
                    int next = fis.read();
                    if (map.containsKey(next)) {
                        map.put(next, map.get(next) + 1);
                    } else map.put(next, 1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            resultMap.put(fileName, map.entrySet().stream().max((a, b) -> a.getValue() > b.getValue() ? 1 : -1).get().getKey());
        }
    }
}
