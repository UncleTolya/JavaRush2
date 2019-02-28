package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName1 = null;
        String fileName2 = null;
        String fileName3 = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = br.readLine();
            fileName2 = br.readLine();
            fileName3 = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis2 = new FileInputStream(fileName2);
            FileInputStream fis3 = new FileInputStream(fileName3);
             FileOutputStream fos = new FileOutputStream(fileName1, true)) {
            if (fis2.available() > 0) {
                byte[] buffer = new byte[fis2.available()];
                int len = fis2.read(buffer);
                fos.write(buffer, 0,len);
            }
            if (fis3.available() > 0) {
                byte[] buffer = new byte[fis3.available()];
                int len = fis3.read(buffer);
                fos.write(buffer, 0,len);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
