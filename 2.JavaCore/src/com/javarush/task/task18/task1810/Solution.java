package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int fileSize = 0;
            do {
                try (FileInputStream fis = new FileInputStream(br.readLine())) {
                    fileSize = fis.available();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (fileSize >= 1000);
            throw new DownloadException();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class DownloadException extends Exception {

    }
}
