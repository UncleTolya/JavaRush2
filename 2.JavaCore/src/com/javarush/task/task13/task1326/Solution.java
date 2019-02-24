package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        String fileName = null; //имя файла

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine(); //читаем имя файла
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            while (br.ready()) {
                list.add(Integer.parseInt(br.readLine())); //парсим строку файла и заносим в лист
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(list); //сортировка

        //проходимся по коллекции и печатаем четные
        for (int i = 0; i < list.size(); i++) { // проверям что выведено меньше четырех
            if (list.get(i) % 2 == 0) {
                System.out.println(list.get(i));
            }
        }
    }
}
