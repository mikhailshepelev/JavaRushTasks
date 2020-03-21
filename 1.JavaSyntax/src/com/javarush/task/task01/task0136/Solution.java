package com.javarush.task.task01.task0136;

/* 
Да хоть на Луну!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeight(888));
    }

    public static double getWeight(int earthWeight) {
    double moon = 0.17 * earthWeight;
    
    return moon;
    //напишите тут ваш код
    }
}