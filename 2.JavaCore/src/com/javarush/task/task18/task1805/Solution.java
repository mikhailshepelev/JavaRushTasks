package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        Set<Long> set = new HashSet<>();
        while (inputStream.available() > 0)
        {
            long data = inputStream.read();
            set.add(data);
        }
        List<Long> list = new ArrayList<>();
        list.addAll(set);
        Collections.sort(list);
        for (long l : list) {
            System.out.print(l + " ");
        }
        reader.close();
        inputStream.close();
    }
}
