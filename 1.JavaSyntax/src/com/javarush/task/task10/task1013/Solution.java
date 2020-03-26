package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private boolean isMale;
        private double weight;
        private int length;
        private String race;

        public Human(String name, int age, boolean isMale) {
            this.name = name;
            this.age = age;
            this.isMale = isMale;
        }

        public Human(double weight, int length) {
            this.weight = weight;
            this.length = length;
        }

        public Human(String name, int age, boolean isMale, String race) {
            this.name = name;
            this.age = age;
            this.isMale = isMale;
            this.race = race;
        }

        public Human(boolean isMale, String race) {
            this.isMale = isMale;
            this.race = race;
        }

        public Human(int age, double weight, int length) {
            this.age = age;
            this.weight = weight;
            this.length = length;
        }

        public Human(String name, int age, boolean isMale, double weight, int length, String race) {
            this.name = name;
            this.age = age;
            this.isMale = isMale;
            this.weight = weight;
            this.length = length;
            this.race = race;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(int age, boolean isMale) {
            this.age = age;
            this.isMale = isMale;
        }

        public Human(double weight, int length, String race) {
            this.weight = weight;
            this.length = length;
            this.race = race;
        }

        public Human(boolean isMale, double weight, int length, String race) {
            this.isMale = isMale;
            this.weight = weight;
            this.length = length;
            this.race = race;
        }
        // Напишите тут ваши переменные и конструкторы
    }
}
