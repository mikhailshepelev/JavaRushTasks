package com.javarush.task.task05.task0511;

/* 
Создать класс Dog
*/

public class Dog {
    public String name = null;
    public int height = 0;
    public String color = null;
    
    public void initialize(String name)
    {
        this.name = name;
    }
    public void initialize(String name, int height, String color)
    {
        this.name = name;
        this.height = height;
        this.color = color;
    }
    public void initialize(String name, int height)
    {
        this.name = name;
        this.height = height;
    }
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
