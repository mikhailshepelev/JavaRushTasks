package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
   Scanner scanner = new Scanner(System.in);
String name1 = scanner.nextLine();
String name2 = scanner.nextLine();
//System.out.println(name1);
//System.out.println(name2);
int length1 = name1.length();
int length2 = name2.length();
if (length1 == length2 && !name1.equals(name2)) System.out.print("Длины имен равны");
if (name1.equals(name2)) System.out.print("Имена идентичны");


//напишите тут ваш код

    }
}
