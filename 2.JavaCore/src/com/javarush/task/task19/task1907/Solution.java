package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String fileName1 = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> strings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName1))) {
            while (br.ready()) {
                strings.add(br.readLine());
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        int count = 0;
        for (String string : strings) {
            String data2 = string.replaceAll("\\bworld\\b", "");
            count += ((string.length() - data2.length()) / 5 );
        }
        System.out.println(count);

    }
}
