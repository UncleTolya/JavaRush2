package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String firstFile = null;
        String secondFile = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            firstFile = br.readLine();
            secondFile = br.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        boolean firstFileRead = readFileAndLoadDadaInList(firstFile, allLines);
        boolean secondFileRead = readFileAndLoadDadaInList(secondFile, forRemoveLines);

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {

//        List<String> list1 = new ArrayList<>(allLines);
//        list1.sort(String::compareTo);
//        List<String> list2 = new ArrayList<>(forRemoveLines);
//        list2.sort(String::compareTo);
        if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }

    public static boolean readFileAndLoadDadaInList(String fileName, List<String> list) {
        if (fileName == null || fileName.equals("")) return false;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))){
            while (br.ready()) list.add(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
