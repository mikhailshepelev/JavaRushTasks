package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
    Cat [] cats = new Cat[10];
    int x = 0;
    while (x<10){
        cats[x] = new Cat();
        x+=1;
    }
    System.out.print(Cat.catCount);
    // Создай 10 котов

        // Выведи значение переменной catCount
    }

    public static class Cat {
        public static int catCount;
        
        public Cat(){
            catCount+=1;
        }
        // Создай статическую переменную catCount

        // Создай конструктор
    }
}
