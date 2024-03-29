package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        String [] array = result.split(" ");
        int first = Integer.parseInt(array[0]);
        int second = Integer.parseInt(array[2]);
        char action = array[1].charAt(0);
        int resultINT = 0;
        if (action == '+') resultINT = first+second;
        else if (action == '-') resultINT = first-second;
        else if (action == '*') resultINT = first*second;
        System.out.println(String.format("%s %s %s = %d", array[0], array[1], array[2], resultINT));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

