package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName1 = args[0];
//        String fileName1 = "/Users/mhlv/Documents/test1";
        String fileName2 = args[1];
//        String fileName2 = "/Users/mhlv/Documents/test2";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName1));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileName2))) {
            StringBuffer sb = new StringBuffer();
            while (br.ready()) {
                sb.append(br.readLine());
                sb.append(" ");
            }
            String[] words = sb.toString().trim().split(" +");
            sb = new StringBuffer();
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 6) {
                    sb.append(words[i] + " ");
                }
            }
            bw.write(sb.toString().trim().replaceAll(" ", ","));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
