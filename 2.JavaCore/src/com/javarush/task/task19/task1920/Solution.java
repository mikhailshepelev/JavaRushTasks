package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        SortedMap<String, Double> map = new TreeMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String [] array = line.split(" ");
            if (map.containsKey(array[0])) {
                map.put(array[0], map.get(array[0]) + Double.parseDouble(array[1]));
            }
            else {
                map.put(array[0], Double.parseDouble(array[1]));
            }
        }
        reader.close();
        double maxValue = Double.MIN_VALUE;
        for(Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() > maxValue) maxValue = pair.getValue();
        }
        SortedMap<String, Double> mapMax = new TreeMap<>();
        for(Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() == maxValue) mapMax.put(pair.getKey(), pair.getValue());
        }
        for(Map.Entry<String, Double> pair : mapMax.entrySet()) {
            System.out.println(pair.getKey());
        }
    }
}
