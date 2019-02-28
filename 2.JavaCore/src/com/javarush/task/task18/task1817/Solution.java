package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];

        int spaces = 0;
        int all = 0;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            all = fis.available();
            while (fis.available() > 0) {
                if (fis.read() == 32) spaces++;
            }
        } catch (IOException e) {

        }
        double result = spaces/(double) all * 100;
        DecimalFormat d = new DecimalFormat("##.00");
        System.out.println(d.format(result));

    }
}
