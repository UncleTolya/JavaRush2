package com.javarush.task.task18.task1809;

/* 
Реверс файла
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
        try (FileInputStream fis = new FileInputStream(fileName1);
             FileOutputStream fos = new FileOutputStream(fileName2)) {
            if (fis.available() > 0) {
                //читаем весь файл одним куском
                byte[] buffer = new byte[fis.available()];
                int count = fis.read(buffer);
                reverseByteArray(buffer, 0, buffer.length);
                fos.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void reverseByteArray(byte arr[], int start, int end)
    {
        int len = end - start;
        if(len <= 0) return;

        int len2 = len >> 1;
        byte temp;

        for (int i = 0; i < len2; ++i)
        {
            temp = arr[start + i];
            arr[start + i] = arr[end - i - 1];
            arr[end - i - 1] = temp;
        }
    }
}
