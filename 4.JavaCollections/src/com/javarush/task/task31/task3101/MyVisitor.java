package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class MyVisitor extends SimpleFileVisitor<Path> {
    private static TreeMap<File, List<String>> map;

    public MyVisitor() {
        map = new TreeMap<>(Comparator.comparing(File::getName));
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileInputStream fis = new FileInputStream(file.toFile());
        if (fis.available() <= 50) {
            map.put(file.toFile(), Files.readAllLines(file));
        }
        return FileVisitResult.CONTINUE;
    }

    public static TreeMap<File, List<String>> getMap() {
        return map;
    }
}
