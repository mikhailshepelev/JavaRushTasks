package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<>();;
    //напишите тут ваш код

    public Cat() {
        
    }

    public static void main(String[] args) {
        int a = 0;
        while (a<10){
            Cat cat = new Cat();
            a++;
            Cat.cats.add(cat);
            
        }
        //напишите тут ваш код
        printCats();
    }

    public static void printCats() {
        for (int index = 0; index<cats.size(); index++)
                System.out.println(cats.get(index));
}
}
