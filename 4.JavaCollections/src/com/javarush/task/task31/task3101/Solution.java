package com.javarush.task.task31.task3101;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;


/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        String inputPath = args[0];
        String resultFileName = args[1];

        MyVisitor mv = new MyVisitor();

        Files.walkFileTree(Paths.get(inputPath), mv);

        File resultFile = new File(resultFileName);

        File newResult = new File(resultFile.getParent() + "/" + "allFilesContent.txt");

        FileUtils.renameFile(resultFile, newResult);

        BufferedWriter bw = new BufferedWriter(new FileWriter(newResult));

        TreeMap<File, List<String>> map = MyVisitor.getMap();

        for (List<String> value : map.values()) {
            for (String s : value) {
                bw.write(s);
            }
            bw.write("\n");
        }

        bw.close();

    }

}
