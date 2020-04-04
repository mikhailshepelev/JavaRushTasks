package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.text.ParseException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        String fileContent = fileReader.readLine();
        fileReader.close();
        String [] array = fileContent.split(" ");

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));
        for (int i = 0; i < array.length; i++) {
            try {
                int a = Integer.parseInt(array[i]);
                fileWriter.write(a + " ");
            }
            catch (Exception e) {
            }
        }
        fileWriter.close();
    }
}
