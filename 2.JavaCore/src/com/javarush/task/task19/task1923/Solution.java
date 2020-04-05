package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String line;
        while ((line = reader.readLine()) != null) {
            String [] array = line.split("\\s");
            for (int i = 0; i < array.length; i++) {
                Pattern p = Pattern.compile(".*\\d.*");
                Matcher m = p.matcher(array[i]);
                if (m.matches()) {
                    writer.write(array[i] + " ");
                }
            }
        }

        reader.close();
        writer.close();
    }
}
