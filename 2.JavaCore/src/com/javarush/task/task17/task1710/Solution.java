package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static String[] param;


    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        param = args;
        switch (param[0]) {
            case "-c" : createAndAdd();
            break;
            case "-u" : update();
            break;
            case "-d" : delete();
            break;
            case "-i" : info();
            break;
        }

    }

    public static void createAndAdd() {
        switch (param[2]) {
            case "м" : allPeople.add(Person.createMale(param[1], convertBD(param[3])));
            break;
            case "ж" : allPeople.add(Person.createFemale(param[1], convertBD(param[3])));
            break;
        }
        System.out.println(allPeople.size() - 1);

    }

    public static void update() {
        switch (param[3]) {
            case "м" : allPeople.set(Integer.parseInt(param[1]) , Person.createMale(param[2], convertBD(param[4])));
            break;
            case "ж" : allPeople.set(Integer.parseInt(param[1]) , Person.createFemale(param[2], convertBD(param[4])));
            break;
        }
    }

    public static void delete() {
        Person person = Person.createMale(null, null);
        person.setSex(null);
        allPeople.set(Integer.parseInt(param[1]) , person );

    }

    public static void info() {
        Person person = allPeople.get(Integer.parseInt(param[1]));
        String name = person.getName();
        String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        Date bd = person.getBirthDate();
        System.out.println(name + " " + sex + " " + format.format(bd));
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
