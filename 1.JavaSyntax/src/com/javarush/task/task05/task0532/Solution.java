package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int maximum = 0;
        int c = Integer.MIN_VALUE;
        if (N>0) {
            while (N>0) {
                int b = Integer.parseInt(reader.readLine());
                if (b>=c) maximum = b;
                else maximum = c;
                c = maximum;
                N--;
            }}
        //напишите тут ваш код

        System.out.println(maximum);
    }
}
