package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        Map<Long, Integer> map = new HashMap<>();
        while (inputStream.available() > 0)
        {
            long data = inputStream.read();
            if (!map.containsKey(data)) map.put(data, 1);
            else {
                for (Map.Entry<Long, Integer> pair : map.entrySet()) {
                    if (pair.getKey() == data) {
                        pair.setValue(pair.getValue()+1);
                    }
                }
            }
        }
        int minValue = Integer.MAX_VALUE;
        for (Map.Entry<Long, Integer> pair : map.entrySet()) {
            if (pair.getValue()<minValue) minValue = pair.getValue();
        }
        for (Map.Entry<Long, Integer> pair : map.entrySet()){
            if (pair.getValue() == minValue) System.out.print(pair.getKey() + " ");
        }
        reader.close();
        inputStream.close();
    }
}
