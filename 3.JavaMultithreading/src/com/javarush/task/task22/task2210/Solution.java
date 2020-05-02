package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String [] array = getTokens("level22.lesson13.task01", ".");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            list.add(token);
        }
        String[] arr = new String[list.size()];
        arr = list.toArray(arr);
        return arr;
    }
}
