package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        int id = Integer.parseInt(args[0]);

        BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readFileName.readLine();
        readFileName.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        String [] rowNeeded;
        while ((line = fileReader.readLine()) != null) {
            rowNeeded = line.split(" ");
            if (Integer.parseInt(rowNeeded[0]) == id) {
                break;
            }
        }
        fileReader.close();

        System.out.println(line);
    }
}
