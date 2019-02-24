package com.javarush.task.task14.task1419;

import java.lang.instrument.IllegalClassFormatException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.IllegalFormatFlagsException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        exceptions.add(new ClassCastException());
        exceptions.add(new ArrayStoreException());
        exceptions.add(new IllegalAccessException());
        exceptions.add(new IllegalArgumentException());
        exceptions.add(new ClassNotFoundException());
        exceptions.add(new IllegalMonitorStateException());
        exceptions.add(new IllegalThreadStateException());
        exceptions.add(new IllegalClassFormatException());
        exceptions.add(new IllegalStateException());
        //напишите тут ваш код

    }
}
