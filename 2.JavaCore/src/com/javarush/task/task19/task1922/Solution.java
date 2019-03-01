package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            ArrayList<String> stringList = null;
            while (br.ready()) {
                String next = br.readLine();
                stringList = new ArrayList<>(Arrays.asList(next.trim().split("\\s+")));
                ArrayList<String> newList = stringList.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
                ArrayList<String> newWords = new ArrayList<>(words);
                newWords.removeAll(newList);
                int ans = words.size() - newWords.size();
                if (ans == 2) System.out.println(next);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
