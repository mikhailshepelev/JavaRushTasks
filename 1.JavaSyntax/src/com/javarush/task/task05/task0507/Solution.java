package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double a = 0;
        double b=0;
        double num1=0;
        while (true) {
            String line = reader.readLine();
            a = Integer.parseInt(line);
            if (a == -1)
            break;
            num1 +=a;
            b++;
        }
        double c = num1/b;
        System.out.print(c);


        //напишите тут ваш код
    }
}

