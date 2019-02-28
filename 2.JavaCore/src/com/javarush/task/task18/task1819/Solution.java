package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

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
        byte[] file1Data = null;
        byte[] file2Data = null;
        try (FileInputStream fis1 = new FileInputStream(fileName1);
            FileInputStream fis2 = new FileInputStream(fileName2)) {
            if (fis1.available() > 0) {
                byte[] buf = new byte[fis1.available()];
                int len = fis1.read(buf);
                file1Data = buf;
            }
            if (fis2.available() > 0) {
                byte[] buf = new byte[fis2.available()];
                int len = fis2.read(buf);
                file2Data = buf;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream(fileName1)) {
            fos.write(file2Data);
            fos.write(file1Data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
