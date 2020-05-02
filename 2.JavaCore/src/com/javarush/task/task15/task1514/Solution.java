package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(29.5, "one");
        labels.put(25.5, "two");
        labels.put(24.5, "three");
        labels.put(23.5, "four");
        labels.put(22.5, "five");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
