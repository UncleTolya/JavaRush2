package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new TestThread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        });
        threads.add(new TestThread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ie) {
                    System.out.println("InterruptedException");
                }
            }
        });
        threads.add(new TestThread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Ура");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        threads.add(new TestThread2());
        threads.add(new TestThread() {
            @Override
            public void run() {
                String s;
                int sum = 0;
                try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                    while (!(s = br.readLine()).equals("N")) {
                        sum += Integer.parseInt(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(sum);
            }
        });
    }
    public static void main(String[] args) {

    }

    public static abstract class TestThread extends Thread {

    }
    public static class TestThread2 extends Thread implements Message {
        boolean cont = true;

        @Override
        public void run() {
            while (cont) {

            }
        }

        @Override
        public void showWarning() {
            if (isAlive()) {
                cont = false;
            }
        }
    }

}