package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter s = new StringWriter();
        try {
            while (is.available() > 0) {
                byte[] buf = new byte[is.available()];
                int len = is.read(buf);
                s.write((new String(buf, "UTF-8")).toCharArray(), 0, len);
            }
        } catch (NullPointerException e) {
            return new StringWriter();
        } finally {
            return s;
        }
    }
}