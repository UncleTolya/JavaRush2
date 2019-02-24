package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int a = 0;
        int b = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            a = Integer.parseInt(br.readLine());
            b = Integer.parseInt(br.readLine());
            if (a < 1 || b < 1) {
                throw new NumberFormatException();
            }
        }

        int min = min(a, b);
        int max = max(a, b);

        int ans = 1;
        for (int i = min; i >= 1; i--) {
            if (min % i == 0 && max % i == 0) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }

    public static int min(int a, int b) {
        return a <= b ? a : b;
    }

    public static int max(int a, int b) {
        return a >= b ? a : b;
    }
}
