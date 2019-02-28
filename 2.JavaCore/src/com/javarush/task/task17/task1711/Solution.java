package com.javarush.task.task17.task1711;


import com.javarush.task.task17.task1711.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2
*/

public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<>();
    public static String[] param;


    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        param = args;

            switch (args[0]) {
                case "-c": synchronized (allPeople){
                    createAndAdd();
                    break;
                }
                case "-u": synchronized (allPeople) {
                    update();
                    break;
                }
                case "-d": synchronized (allPeople) {
                    delete();
                    break;
                }
                case "-i": synchronized (allPeople) {
                    info();
                    break;
                }
            }

    }

    public static void createAndAdd() {
        for (int i = 1; i < param.length; i+=3) {
            switch (param[i + 1]) {
                case "м":
                    allPeople.add(Person.createMale(param[i], convertBD(param[i + 2])));
                    break;
                case "ж":
                    allPeople.add(Person.createFemale(param[i], convertBD(param[i + 2])));
                    break;
            }
            System.out.println(allPeople.size() - 1);
        }

    }

    public static void update() {
        for (int i = 1; i < param.length; i+=4) {
            switch (param[i + 2]) {
                case "м":
                    allPeople.set(Integer.parseInt(param[i]), Person.createMale(param[i + 1], convertBD(param[i + 3])));
                    break;
                case "ж":
                    allPeople.set(Integer.parseInt(param[i]), Person.createFemale(param[i + 1], convertBD(param[i + 3])));
                    break;
            }
        }
    }

    public static void delete() {
        for (int i = 1; i < param.length; i++) {
            Person person = Person.createMale(null, null);
            person.setSex(null);
            allPeople.set(Integer.parseInt(param[i]), person);
        }

    }

    public static void info() {
        for (int i = 1; i < param.length; i++) {
            Person person = allPeople.get(Integer.parseInt(param[i]));
            String name = person.getName();
            String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            Date bd = person.getBirthDate();
            System.out.println(name + " " + sex + " " + format.format(bd));
        }
    }


    public static Date convertBD(String string) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
