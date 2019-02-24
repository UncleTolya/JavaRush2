package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String string = null;
          while (!(string = br.readLine()).equals("exit")) {
              try {
                  int num;
                  if (new ArrayList<String>(Arrays.asList(string.split(""))).contains(".")) {
                      print(Double.parseDouble(string));
                  }else if((num = Integer.parseInt(string)) > 0 && num < 128) {
                      print((short) num);
                  } else print(num);
              } catch (NumberFormatException e) {
                  print(string);
              }
          }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
