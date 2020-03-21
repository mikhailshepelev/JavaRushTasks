package com.javarush.task.task05.task0514;

/* 
Программист создает человека
*/

public class Solution {
    public static void main(String[] args) {
        Person person = new Person();
        person.initialize("Misha", 31);
        //напишите тут ваш код
    }

    static class Person {
    public String name = null;
    public int age = 0;
    
    public void initialize(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
        //напишите тут ваш код
    }
}
