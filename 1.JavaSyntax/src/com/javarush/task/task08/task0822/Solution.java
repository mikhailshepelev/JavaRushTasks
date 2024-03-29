package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        Collection<Integer> coll = array;
        int min = Collections.min(coll);
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String line = reader.readLine();
        int n = Integer.parseInt(line);
        for (int i = 0; i<n; i++) {
            String line1 = reader.readLine();
            int val = Integer.parseInt(line1);
            list.add(val);
        }
        return list;
    }
}
