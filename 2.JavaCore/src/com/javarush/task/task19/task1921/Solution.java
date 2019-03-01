package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        String fileName = args[0];
//        String fileName = "/Users/mhlv/Documents/test3 copy";
        TreeMap<String, Double> map = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                String next = br.readLine();
                String[] values =  next.trim().split("\\s+");
                String year = values[values.length - 1];
                String month = values[values.length - 2];
                String day = values[values.length - 3];
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < values.length - 3; i++) {
                    sb.append(values[i]);
                    if (i + 1 < values.length - 3) sb.append(" ");
                }
                String name = sb.toString();
                String bdString = day + " " + month + " " + year;
                SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
                Date bd = null;
                try {
                    bd = format.parse(bdString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                PEOPLE.add(new Person(name, bd));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        double maxValue = Double.MIN_VALUE;

        for (Person person : PEOPLE) {
            System.out.println(person.getName() + " " + person.getBirthDate());
        }
    }
}
