package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
     System.out.println(convertEurToUsd(100, 1.17));    //напишите тут ваш код
System.out.println(convertEurToUsd(150, 1.25));
    }

    public static double convertEurToUsd(int eur, double course) {
     double dollar = eur*course;
     return dollar;
        //напишите тут ваш код

    }
}
