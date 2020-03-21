package com.javarush.task.task03.task0304;

/* 
Задача на проценты
*/

public class Solution {
    public static double addTenPercent(int i) {
    double c = i + 0.1*i;
     return c;   //напишите тут ваш код

    }

    public static void main(String[] args) {
        System.out.println(addTenPercent(9));
    }
}
