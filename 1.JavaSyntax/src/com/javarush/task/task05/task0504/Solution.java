package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
   Cat cat1 = new Cat("vaska", 20, 30, 10);
   Cat cat2 = new Cat("murka", 30, 11, 12);
   Cat cat3 = new Cat("tuzhurka", 50, 40, 10);
        //напишите тут ваш код
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}