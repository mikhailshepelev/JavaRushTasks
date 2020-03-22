package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
    int c = a+b;
        //напишите тут ваш код
        return c;
    }

    public static int minus(int a, int b) {
      int c = a-b;
        //напишите тут ваш код
        return c;
    }

    public static int multiply(int a, int b) {
       int c = a*b;
        //напишите тут ваш код
        return c;
    }

    public static double division(int a, int b) {
      double c = (double) a / (double) b;
        //напишите тут ваш код
        return c;
    }

    public static double percent(int a, int b) {
    double c =  ((double) a * (double) b)/100.0;
        //напишите тут ваш код
        return c;
    }

    public static void main(String[] args) {

    }
}