package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
   public String name = null;
   public int weight = 0;
   public int age = 0;
   public String color = null;
   public String address = null;
   
   public void initialize(String name) {
       this.name = name;
       this.age = 50;
       this.weight = 60;
       this.color = "red";
   }
   public void initialize(String name, int weight, int age) {
       this.name = name;
       this.age = age;
       this.weight = weight;
       this.color = "red";
   }
   public void initialize(String name, int age) {
       this.name = name;
       this.age = age;
       this.weight = 50;
       this.color = "red";
   }
   public void initialize(int weight, String color) {
       this.age = 50;
       this.weight = weight;
       this.color = color;
   }
   public void initialize(int weight, String color, String address) {
       this.age = 30;
       this.weight = weight;
       this.color = color;
       this.address = address;
   }
   
   //напишите тут ваш код

    public static void main(String[] args) {

    }
}
