package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   int [] a = new int[20];
        for (int i = 0; i<a.length; i++) {
            String line = reader.readLine();
            a[i] = Integer.parseInt(line);
        }
        int [] b = new int[10];
        int [] c = new int[10];
        for (int i = 0; i<a.length-10; i++){
            b[i] = a[i];
        }
        for (int i = 10; i<a.length; i++){
            c[i-10] = a[i];
            System.out.println(c[i-10]);
        }    //напишите тут ваш код
    }
}
