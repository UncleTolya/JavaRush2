package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {

    public static void main(String[] args) {
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                fileName = br.readLine();
                try (FileInputStream fis = new FileInputStream(fileName)) {

                } catch (FileNotFoundException e) {
                    System.out.println(fileName);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
