package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(file);
        StringBuilder builder = new StringBuilder();
        while (fileReader.ready()) {
            int data = fileReader.read();
            builder.append((char) data);
        }
        fileReader.close();
        String result = builder.toString();
        String [] array = result.split("\\W");
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("world")) counter++;
        }
        System.out.println(counter);
    }
}
