package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
   
    //напишите тут ваш код

    public static void main(String[] args) {
       System.out.println(convertToSeconds(1));
       System.out.println(convertToSeconds(15));//напишите тут ваш код

    }
     public static int convertToSeconds(int hours) {
        int seconds = hours*60*60;
        return seconds;
    }
}
