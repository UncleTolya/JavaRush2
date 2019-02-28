package com.javarush.task.task18.task1825;

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> fileNames = readFilenamesFromConsoleToList();

        sortNamesByPart(fileNames);

        String resultFile = fileNames.get(0).substring(0, fileNames.get(0).lastIndexOf("."));

        readAllFilesFromListAndWriteToFile(fileNames, resultFile);
    }

    public static void sortNamesByPart(ArrayList<String> fileNames) {
        fileNames.sort((a, b) -> {
            int numFirst = Integer.parseInt(a.substring(a.lastIndexOf("."))
                    .replaceFirst("\\D*", "" ));
            int numSecond = Integer.parseInt(b.substring(a.lastIndexOf("."))
                    .replaceFirst("\\D*", "" ));
            return numFirst - numSecond;
        });
    }

    public static void readFileAndWriteToOutputStream(String fileName, FileOutputStream fos) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                byte[] buf = new byte[fis.available()];
                int len = fis.read(buf);
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileToFile(String fileName, String resultFile) {
        try (FileOutputStream fos = new FileOutputStream(resultFile, true)) {
            readFileAndWriteToOutputStream(fileName, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAllFilesFromListAndWriteToFile(List<String> fileNames, String resultFile) {
        for (String fileName : fileNames) {
            writeFileToFile(fileName, resultFile);
        }
    }

    public static ArrayList<String> readFilenamesFromConsoleToList() {
        ArrayList<String> fileNames = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName;
            while (!(fileName = br.readLine()).equals("end")) {
                fileNames.add(fileName.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileNames;
    }
}
