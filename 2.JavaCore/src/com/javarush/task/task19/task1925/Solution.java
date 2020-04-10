package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            String[] inputArray = line.split("\\s");
            for (int i = 0; i < inputArray.length; i++) {
                if (inputArray[i].length() > 6) {
                    builder.append(inputArray[i] + ",");
                }
            }
        }
        reader.close();

        String result = builder.toString();
        if (result.endsWith(",")) {
            result = result.substring(0, result.length()-1);
        }

        writer.write(result);
        writer.close();
    }
}
