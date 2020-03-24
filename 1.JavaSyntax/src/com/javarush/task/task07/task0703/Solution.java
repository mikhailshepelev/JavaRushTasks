package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[10];
        int[] num = new int[10];
        for (int i = 0; i<str.length; i++){
            str[i] = reader.readLine();
            int a = 0;
            for(a=0; a < str[i].length(); a++)
            {
            }
            num[i] = a;
            System.out.println(a);
        }    //напишите тут ваш код
    }
}
