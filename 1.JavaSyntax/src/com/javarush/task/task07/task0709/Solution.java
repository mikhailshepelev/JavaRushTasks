package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> mins = new ArrayList<String>();
        String min = "";
        for (int i = 0; i < 5; i++) {
            String line = reader.readLine();
            list.add(line);}
        int temp = 2147483645;
        for (int i = 0; i<list.size(); i++){
            String m = list.get(i);
            if (m.length()<temp){temp = m.length(); mins.clear(); mins.add(m);}
            else if (m.length() == temp){mins.add(m); temp = m.length();}
        }
        for (String b: mins) {
            System.out.println(b);
        }
        }
}
