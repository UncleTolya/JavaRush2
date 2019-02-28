package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        String code = args[0];
        String fileName = args[1];
        String resultFile = args[2];

        switch (code) {
            case "-e" : encrypt(fileName, resultFile);
            break;
            case "-d" : decrypt(fileName, resultFile);
        }

    }

    public static void encrypt(String fileName, String resultFile) {
        try (FileInputStream fis = new FileInputStream(fileName);
            FileOutputStream fos = new FileOutputStream(resultFile)) {
            while (fis.available() > 0) {
                int next = fis.read();
                fos.write(next);
                fos.write(next);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decrypt(String fileName, String resultFile) {
        try (FileInputStream fis = new FileInputStream(fileName);
             FileOutputStream fos = new FileOutputStream(resultFile)) {
            while (fis.available() > 0) {
                int next = fis.read();
                fos.write(next);
                fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
