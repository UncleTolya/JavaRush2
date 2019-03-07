package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> answer = new ArrayList<>();
        MyVisitor mv = new MyVisitor();
        Files.walkFileTree(Paths.get(root), mv);

        return MyVisitor.getList();

    }

    public static void main(String[] args) {
        
    }
}
