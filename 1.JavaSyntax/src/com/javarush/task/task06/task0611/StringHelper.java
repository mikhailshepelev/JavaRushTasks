package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        result = s+s+s+s+s;
        //напишите тут ваш код
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        int a = 0;
        while (a<count) {result += s; a++;}
        //напишите тут ваш код
        return result;
    }

    public static void main(String[] args) {

    }
}
