package com.javarush.task.task02.task0213;

/* 
Питомцам нужны люди
*/
public class Solution {
    public static void main(String[] args) {
    Cat cat = new Cat();
    Dog dog = new Dog();
    Fish fish = new Fish();
    Woman woman = new Woman();
   
   cat.owner = new Woman();
   dog.owner = new Woman();
   fish.owner = new Woman();
        //напишите тут ваш код
    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
      //  public Woman owner;
    }
}
