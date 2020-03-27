package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int i;
        int spacesCount = 0;
        int symbolsCount = 0;
        while((i=fileInputStream.read())!= -1){
            if (i == 32) spacesCount++;
            symbolsCount++;
        }
        fileInputStream.close();
        double result = (double) spacesCount / (double) symbolsCount * 100;
        System.out.println(String.format("%.2f", result));
    }
}
