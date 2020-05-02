package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String line = reader.readLine();
            if (line.equals("exit")) break;
            else if (line.contains(".")) {
                try {
                    Double a = Double.parseDouble(line);
                    print(a);
                }
                catch (Exception e){
                    print(line);
                }
            }
            else {
                try {
                    int b = Integer.parseInt(line);
                    if (b>0 && b<128) {
                        short shortInt = (short) b;
                        print(shortInt);
                    }
                    else print(b);
                }
                catch (Exception e){
                    print(line);
                }
            }
        }

        //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
