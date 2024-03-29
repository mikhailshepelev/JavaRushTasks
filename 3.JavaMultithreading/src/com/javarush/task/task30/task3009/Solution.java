package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 2; i <= 36; i++) {
            try {
                String value = Integer.toString(Integer.parseInt(number), i);
                stringBuilder.append(value);
                if  (value.equals(stringBuilder.reverse().toString())) {
                    set.add(i);
                }
            } catch (NumberFormatException ignored) {

            } finally {
                stringBuilder.setLength(0);
            }
        }

        return set;
    }
}