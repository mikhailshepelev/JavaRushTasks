package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        String t = args[0];

        FileReader fileReader = new FileReader(fileName);
        StringBuilder builder = new StringBuilder();
        while (fileReader.ready()) {
            int data = fileReader.read();
            builder.append((char) data);
        }
        fileReader.close();
        String result = builder.toString();

        Pattern p = Pattern.compile(("<"+t+".*>.*?</"+t+">"));
        Matcher m = p.matcher(result);
        while (m.find()) {
            System.out.println(m.start() + " " + m.group());
        }

    }
}
