package com.javarush.task.task18.task1820;

/* 
Округление чисел
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
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName2)));
             BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)))) {
            StringBuilder sb = new StringBuilder();
            while (br.ready()) sb.append(br.readLine());
            ArrayList<String> file1Data = new ArrayList<>(Arrays.asList(sb.toString().trim().split(" ")));
            DecimalFormat d = new DecimalFormat("#");
            for (String string : file1Data) {
                double next = Double.parseDouble(string);
//                bw.append(d.format(next) + " ");
                bw.append(Math.round(next) + " ");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
