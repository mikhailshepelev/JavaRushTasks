package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
    int a = 1;
    int b = 1;
    while (a<11) {
    while (b<11) {
        System.out.print(a*b + " ");
        b++;
    }
    System.out.println("");
        a++;
        b = (b-10);
    }
    //напишите тут ваш код

    }
}
