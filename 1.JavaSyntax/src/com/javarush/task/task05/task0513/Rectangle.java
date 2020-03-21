package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    public int top = 0;
    public int left = 0;
    public int width = 0;
    public int height = 0;
    
    public void initialize(int top)
    {
        this.top = top;
    }
    
    public void initialize(int top, int left)
    {
        this.top = top;
        this.left = left;
    }
    
    public void initialize(int top, int left, int width)
    {
        this.top = top;
        this.left = left;
        this.width = width;
    }
    public void initialize(int top, int left, int width, int height)
    {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
