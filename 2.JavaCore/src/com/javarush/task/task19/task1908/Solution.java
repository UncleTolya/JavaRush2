package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName1 = null;
        String fileName2 = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = br.readLine();
            fileName2 = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileName1));
             BufferedWriter bw  = new BufferedWriter(new FileWriter(fileName2))) {
            String nextLine;
            while (br.ready()) {
                nextLine = br.readLine();
                for (String part : nextLine.trim().split("\\s")) {
                    if (part.matches(".*\\b\\d+\\b.*"))
                    bw.write(part + " ");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
