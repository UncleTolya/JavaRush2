package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        String fileName1 = null;
        String fileName2 = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = br.readLine();
            fileName2 = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String fileName1 = "/Users/mhlv/Documents/test1";
//        String fileName2 = "/Users/mhlv/Documents/test2";
        ArrayList<String> list1 = readToList(fileName1);
        ArrayList<String> list2 = readToList(fileName2);

        int i = 0;
        int j = 0;
        while (i < list1.size() || j < list2.size()) {
            if (i < list1.size() && j >= list2.size()) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                break;
            } else if (i >= list1.size() && j < list2.size()) {
                lines.add(new LineItem(Type.ADDED, list2.get(j)));
                break;
            } else if(list1.get(i).equals(list2.get(j))) {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
                i++;
                j++;
            } else if (!list1.get(i).equals(list2.get(j))) {
                if (i + 1 < list1.size() && j + 1 >= list2.size()) {
                    if (list1.get(i + 1).equals(list2.get(j))) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                        i++;
                    }
                } else if(i + 1 >= list1.size() && j + 1 < list2.size()) {
                    if (list1.get(i).equals(list2.get(j + 1))) {
                        lines.add(new LineItem(Type.ADDED, list2.get(j)));
                        j++;
                    }
                }
                if (j + 1 < list2.size()) {
                    if (list1.get(i).equals(list2.get(j + 1))) {
                        lines.add(new LineItem(Type.ADDED, list2.get(j)));
                        j++;
                        continue;
                    }
                }
                if(i + 1 < list1.size()) {
                    if (list1.get(i + 1).equals(list2.get(j))) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                        i++;
                        continue;
                    }
                }
            }
        }

//        for (LineItem item : lines) {
//            System.out.println(item.type + " " + item.line);
//        }

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

    public static ArrayList<String> readToList(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                list.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
