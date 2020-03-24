package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<String>();
        ArrayList<String> mins = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            String line = reader.readLine();
            strings.add(line);}
        int temp = -2147483648;
        for (int i = 0; i<strings.size(); i++){
            String m = strings.get(i);
            if (m.length()>temp){temp = m.length(); mins.clear(); mins.add(m);}
            else if (m.length() == temp){mins.add(m); temp = m.length();}
        }
        for (String b: mins) {
            System.out.println(b);
        }
    }
}
