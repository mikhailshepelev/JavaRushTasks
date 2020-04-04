package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));

        while (fileReader.ready())
        {
            int data = fileReader.read();
            if (!Pattern.matches("[\\p{Punct}\\n]", Character.toString((char) data))) {
                fileWriter.write(data);
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
