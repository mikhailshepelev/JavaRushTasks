package com.javarush.task.task04.task0405;

/* 
Задаем количество котов
*/

public class Cat {
    private static int catsCount = 0;

    public static void setCatsCount(int catsCount) {
   Cat cat1 = new Cat();
   cat1.catsCount++;
   Cat cat2 = new Cat();
   cat2.catsCount++;
   Cat.catsCount = catsCount;
    //Cat.catsCount++;
    

 
 //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
