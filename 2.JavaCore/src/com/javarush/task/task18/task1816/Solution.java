package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            fileName = br.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        int countOfEnglishLit = 0;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                int next = fis.read();
                if ((next >= 65 && next <= 90) || (next >= 97 && next <= 122) ) {
                    countOfEnglishLit++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(countOfEnglishLit);
    }
}
