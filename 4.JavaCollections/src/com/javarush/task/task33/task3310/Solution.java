package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 1000);
        testStrategy(new OurHashMapStorageStrategy(), 1000);
        testStrategy(new FileStorageStrategy(), 100);
        testStrategy(new OurHashBiMapStorageStrategy(), 1000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> ids = new HashSet<>();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>();
        for (Long key : keys) {
            strings.add(shortener.getString(key));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> randomStrings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)
            randomStrings.add(Helper.generateRandomString());

        Shortener shortener = new Shortener(strategy);

        Date date1 = new Date();
        Set<Long> ids = getIds(shortener, randomStrings);
        Date date2 = new Date();
        long timeForIds = date2.getTime() - date1.getTime();
        System.out.println(timeForIds);

        Date date3 = new Date();
        Set<String> strings = getStrings(shortener, ids);
        Date date4 = new Date();
        long timeForStrings = date4.getTime() - date3.getTime();
        System.out.println(timeForStrings);

        if (ids.size() == strings.size())
            System.out.println("Тест пройден.");
        else
            System.out.println("Тест не пройден.");


    }
}
