package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<10; i++){
            String a = reader.readLine();
            list.add(a);
        }
        for (int i = 0; i<list.size()-1; i++){
            if (list.get(i+1).length() <= list.get(i).length()) {System.out.println(i+1);
            break;}
            }
        }
    }

