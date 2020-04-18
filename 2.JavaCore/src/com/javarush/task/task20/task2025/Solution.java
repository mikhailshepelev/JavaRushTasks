package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        List<Long> list = new ArrayList<>();
        if (N<Long.MAX_VALUE) {
            int numberOfDigits = 1;
            long multiplier = 10;
            for (long i = 1; i < N; i++) {
                int sum = 0;
                if (i >= multiplier) {
                    numberOfDigits++;
                    multiplier *= 10;
                }
                long number = i;
                while (number > 0) {
                    sum += Math.pow((number % 10), numberOfDigits);
                    if (sum > i) {
                        sum = 0;
                        break;
                    }
                    number = number / 10;
                }
                if (sum == i) {
                    list.add(i);
                }
            }
        }

        long[] result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Date start = new Date();
        long[] a = getNumbers(Long.MAX_VALUE-1);
        Date end = new Date();

        System.out.println(end.getTime() - start.getTime());
    }
}
