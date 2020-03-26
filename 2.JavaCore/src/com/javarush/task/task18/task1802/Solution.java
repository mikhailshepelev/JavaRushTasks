package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        long min = Long.MAX_VALUE;

        while (inputStream.available() > 0)
        {
            long data = inputStream.read();
            if (data<min) {
                min = data;
            }
        }
        System.out.println(min);
        reader.close();
        inputStream.close();
    }
}
