package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        String line;
        List<String> listOfStrings = new ArrayList<>();
        while ((line = reader1.readLine()) != null){
            String [] splitedArray = line.split(" ");
            listOfStrings.addAll(Arrays.asList(splitedArray));
        }
        List<Double> listOfDoubles = new ArrayList<>();
        for (String s : listOfStrings) {
            listOfDoubles.add(Double.parseDouble(s));
        }
        for(double d : listOfDoubles){
            int a = (int) Math.round(d);
            String str = Integer.toString(a);
            writer.write(str);
            writer.write(" ");
        }
        reader1.close();
        writer.close();
    }
}
