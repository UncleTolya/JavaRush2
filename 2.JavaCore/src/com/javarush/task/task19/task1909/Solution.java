package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName2))) {
            while (br.ready()) {
                String next = br.readLine();
                next = next.replaceAll("[.]", "!");
                bw.write(next);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
