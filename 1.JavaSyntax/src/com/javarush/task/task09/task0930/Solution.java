package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<Integer> ints = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i<array.length; i++){
            if (isNumber(array[i])) {
                int a = Integer.parseInt(array[i]);
                ints.add(a);
            }
            else strings.add(array[i]);
        }
        Collections.sort(ints);
        Collections.reverse(ints);
        List<String> newList = new ArrayList<String>();
        for (Integer myInt : ints) {
            newList.add(String.valueOf(myInt));
        }
        String [] str = new String[strings.size()];
        for (int i = 0; i<str.length; i++){
            str[i] = strings.get(i);
        }
        int size = str.length;
        for(int i = 0; i<size-1; i++) {
            for (int j = i+1; j<str.length; j++) {
                if(isGreaterThan(str[i], str[j])) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        int intCount = 0;
        int strCount = 0;
        for (int i = 0; i<array.length; i++){
            if (isNumber(array[i])) {
                array[i] = newList.get(intCount);
                ++intCount;
            }
            else {
                array[i] = str[strCount];
                ++strCount;
            }
        }
        // напишите тут ваш код
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
