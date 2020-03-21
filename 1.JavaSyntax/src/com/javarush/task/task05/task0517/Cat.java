package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    public String name;
    public int weight;
    public int age;
    public String color;
    public String address;
   
   public Cat(String name) {
       this.name = name;
       this.age = 50;
       this.weight = 60;
       this.color = "red";
   }
   public Cat(String name, int weight, int age) {
       this.name = name;
       this.age = age;
       this.weight = weight;
       this.color = "red";
   }
   public Cat(String name, int age) {
       this.name = name;
       this.age = age;
       this.weight = 50;
       this.color = "red";
   }
   public Cat(int weight, String color) {
       this.age = 50;
       this.weight = weight;
       this.color = color;
   }
   public Cat(int weight, String color, String address) {
       this.age = 30;
       this.weight = weight;
       this.color = color;
       this.address = address;
   }
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
