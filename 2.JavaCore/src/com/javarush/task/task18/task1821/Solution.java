package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);

        SortedMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 128; i++) {
            map.put(i, 0);
        }

        while (inputStream.available() > 0){
            int i = inputStream.read();
            for (Map.Entry<Integer, Integer> pair : map.entrySet()){
                if (i == pair.getKey()) {
                    pair.setValue(pair.getValue()+1);
                    break;
                }
            }
        }
        inputStream.close();

        SortedMap<Integer, Integer> resultMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() != 0) {
                resultMap.put(pair.getKey(), pair.getValue());
            }
        }
        for (Map.Entry<Integer, Integer> pair : resultMap.entrySet()){
            int a = pair.getKey();
            char c = (char) a;
            System.out.println(c + " " + pair.getValue());
        }
    }
}
