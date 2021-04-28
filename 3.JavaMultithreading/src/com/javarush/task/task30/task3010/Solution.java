package com.javarush.task.task30.task3010;

import java.math.BigInteger;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {

        int lowestRadix = 0;

        for (int i = 2; i <= 36; i++) {
            try {
                new BigInteger(args[0], i);
                lowestRadix = i;
                break;
            } catch (Exception ignored) {

            }
        }

        if (lowestRadix == 0) {
            System.out.println("incorrect");
        } else {
            System.out.println(lowestRadix);
        }

    }
}