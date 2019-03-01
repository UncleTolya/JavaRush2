package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
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
            while (br.ready()) {
                String string = br.readLine();
                String[] arr = string.trim().split(" ");
                for (int i = 0; i < arr.length; i++) {
                    String[] arr2 = arr[i].split("");
                    for (int j = 0; j < arr2.length; j++) {
                        if (Character.isDigit(arr2[j].charAt(0))) {
                            bw.write(arr[i] + " ");
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
