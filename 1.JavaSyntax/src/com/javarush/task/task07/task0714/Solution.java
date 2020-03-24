package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

/* 
Слова в обратном порядке
*/

public class Solution {
   public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            String line = reader.readLine();
            list.add(line);
        }
        list.remove(2);
        for (int i = list.size()-1; i>=0; i--){
            System.out.println(list.get(i));
        }
    }
}
