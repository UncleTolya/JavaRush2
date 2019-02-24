package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        String string = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            string = br.readLine();
            if (string.equals("helicopter")) {
                result = new Helicopter();
            } else if (string.equals("plane")) {
                result = new Plane(Integer.parseInt(br.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
