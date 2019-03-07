package com.javarush.task.task31.task3102;

import java.io.File;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MyVisitor extends SimpleFileVisitor<Path> {
    private static List<String> list;

    public MyVisitor() {
        list = new ArrayList<>();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isDirectory(file))return FileVisitResult.CONTINUE;
        list.add(file.toString());
        return FileVisitResult.CONTINUE;
    }

    public static List<String> getList() {
        return list;
    }
}
