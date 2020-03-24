package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        StringBuffer s = new StringBuffer();
        char ch = ' ';
        for (int i = 0; i < string.length(); i++) {
            if (ch == ' ' && string.charAt(i) != ' ') {
                s.append(Character.toUpperCase(string.charAt(i)));
            }
            else
                s.append(string.charAt(i));
            ch = string.charAt(i);

        }
        System.out.println(s);
    }
}
