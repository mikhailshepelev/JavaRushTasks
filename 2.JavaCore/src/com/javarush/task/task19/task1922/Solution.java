package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = fileReader.readLine()) != null) {
            String [] array = line.split("\\s");
            int counter = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < words.size(); j++) {
                    if (array[i].equals(words.get(j))) {
                        counter++;
                        break;
                    }
                }
            }
            if (counter == 2) {
                System.out.println(line);
            }
        }
        fileReader.close();
    }
}
