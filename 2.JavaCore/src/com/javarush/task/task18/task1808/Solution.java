package com.javarush.task.task18.task1808;

/* 
Разделение файла
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

        try (FileInputStream fis = new FileInputStream(fileName1);
             FileOutputStream fos2 = new FileOutputStream(fileName2);
             FileOutputStream fos3 = new FileOutputStream(fileName3)) {
            int fisSize = fis.available();
            if (fisSize > 0) {
                byte[] buffer = new byte[fisSize];
                int count = fis.read(buffer);
                if (fisSize == 1) {
                    fos3.write(buffer, 0, count);
                } else {
                    fos2.write(buffer, 0, count /2 + count % 2);
                    fos3.write(buffer, count / 2 + count % 2, count/2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
