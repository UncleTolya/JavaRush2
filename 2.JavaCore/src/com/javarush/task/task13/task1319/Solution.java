package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();

            String string = "";
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            while (!string.equals("exit")) {
                string = br.readLine();
                bw.write(string);
                bw.write("\n");
            }
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
