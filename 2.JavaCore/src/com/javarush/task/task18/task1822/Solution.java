package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String id = args[0];
        String fileName = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            while (br.ready()) {
                String string = br.readLine();
                if (string.trim().startsWith(id + " ")) {
                    System.out.println(string);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
