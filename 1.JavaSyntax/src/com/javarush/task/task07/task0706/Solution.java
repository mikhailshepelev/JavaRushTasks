package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] a = new int[15];
        int even = 0;
        int odd = 0;
        for (int i = 0; i<a.length; i++){
            String line = reader.readLine();
            a[i] = Integer.parseInt(line);
        }
        for (int i = 0; i<a.length; i +=2) {
            even += a[i];
        }
        for (int i = 1; i<a.length; i +=2){
            odd += a[i];
        }
        if (even>odd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
