package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

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
        try (FileReader fis = new FileReader(fileName1);
             FileWriter fos = new FileWriter(fileName2)) {
            fis.read();
            for (int i = 0; fis.ready(); i++) {
                int next = fis.read();
                if (i % 2 == 0) fos.write(next);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
