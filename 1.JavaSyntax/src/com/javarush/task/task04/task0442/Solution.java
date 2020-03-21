package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum =0;
        while (true) {
            int number = input.nextInt();
            if (number == -1)
            break;
            sum += number;
        }
        System.out.println(sum-1);
    }
}
