package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

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
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<Long, Integer> pair : map.entrySet()) {
            if (pair.getValue()>maxValue) maxValue = pair.getValue();
        }
        for (Map.Entry<Long, Integer> pair : map.entrySet()){
            if (pair.getValue() == maxValue) System.out.print(pair.getKey() + " ");
        }
        reader.close();
        inputStream.close();
    }
}
