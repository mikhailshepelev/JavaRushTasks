package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        long max = Long.MIN_VALUE;

        while (inputStream.available() > 0)
        {
            long data = inputStream.read();
            if (data>max) {
                max = data;
            }
        }
        System.out.println(max);
        reader.close();
        inputStream.close();
    }
}
