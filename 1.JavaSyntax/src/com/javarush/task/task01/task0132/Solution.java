package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
   int summ = number/100 + number/10 % 10 + number % 10;
    return summ;
    //напишите тут ваш код
    }
}