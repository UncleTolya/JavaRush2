package com.javarush.task.task19.task1916;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();


    public static void main(String[] args) {
        ArrayList<String> filenames = getFileNames(2);
        String fileName1 = filenames.get(0);
        String fileName2 = filenames.get(1);


        ArrayList<ArrayList<String>> filesAsLists = getFilesAsLists(fileName1, fileName2);
        ArrayList<String> file1 = filesAsLists.get(0);
        ArrayList<String> file2 = filesAsLists.get(1);

        fillLines(file1, file2);

    }

    private static void fillLines(ArrayList<String> file1, ArrayList<String> file2) {
        for (int i = 0; i < file2.size(); i++) {
            if (file2.get(i).equals(file1.get(i)))  {
                lines.add(new LineItem(Type.SAME, file2.get(i)));
            } else {
                file2.get(i).equals(file1.get(i + 1));
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

    public static ArrayList<String> getFileNames(int count) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < count; i++) {
                list.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<ArrayList<String>> getFilesAsLists(String fileName1, String fileName2) {
        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();

        try (BufferedReader readerFile1 = new BufferedReader(new FileReader(fileName1));
             BufferedReader readerFile2 = new BufferedReader(new FileReader(fileName2))) {

            while (readerFile1.ready()) {
                file1.add(readerFile1.readLine());
            }

            while (readerFile2.ready()) {
                file2.add(readerFile2.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<ArrayList<String>> files = new ArrayList<>();
        files.add(file1);
        files.add(file2);

        return files;
    }

}
