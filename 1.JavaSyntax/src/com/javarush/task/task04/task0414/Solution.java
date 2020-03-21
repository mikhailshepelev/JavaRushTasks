package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int y = Integer.parseInt(name);
        if (y>=400) {
            int a = y%400;
        if (a==0) System.out.println("количество дней в году: 366");
        else {
            if (a>=100) {int b = a%100; if (b==0) System.out.println("количество дней в году: 365");
        else {
            if (b>=4) {
                int c = b % 4;
                if (c == 0) System.out.println("количество дней в году: 366");
                else System.out.println("количество дней в году: 365");
            } else System.out.println("количество дней в году: 365"); }}
        else {
                int b = a % 4;
                if (b == 0) System.out.println("количество дней в году: 366");
                else System.out.println("количество дней в году: 365");
            }}}

        else {
            if (y>=100) {int a = y%100; if (a==0) System.out.println("количество дней в году: 365");
            else {
                if (a>=4) {
                    int b = a % 4;
                    if (b == 0) System.out.println("количество дней в году: 366");
                    else System.out.println("количество дней в году: 365");
                } else System.out.println("количество дней в году: 365"); }}
            else {
                int a = y % 4;
                if (a == 0) System.out.println("количество дней в году: 366");
                else System.out.println("количество дней в году: 365");
            }
        }
    }
}