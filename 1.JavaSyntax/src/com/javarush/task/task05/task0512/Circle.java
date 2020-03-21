package com.javarush.task.task05.task0512;

/* 
Создать класс Circle
*/

public class Circle {
    public int centerX = 0;
    public int centerY = 0;
    public int radius = 0;
    public int width = 0;
    public int color = 0;
    
    public void initialize(int centerX, int centerY, int radius)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }
    public void initialize(int centerX, int centerY, int radius, int width)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
    }
    public void initialize(int centerX, int centerY, int radius, int width, int color)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }
    
    
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
