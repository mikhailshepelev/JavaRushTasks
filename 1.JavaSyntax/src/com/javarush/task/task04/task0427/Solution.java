package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
String name = reader.readLine();
int a = Integer.parseInt(name); 
int b = a%2;
if (b!=0 && a>0 && a<10) System.out.print("нечетное однозначное число");
if (b==0 && a>0 && a<10) System.out.print("четное однозначное число");
if (b!=0 && a>=10 && a<100) System.out.print("нечетное двузначное число");
if (b==0 && a>=10 && a<100) System.out.print("четное двузначное число");
if (b!=0 && a>=100 && a<1000) System.out.print("нечетное трехзначное число");
if (b==0 && a>=100 && a<1000) System.out.print("четное трехзначное число");
//напишите тут ваш код

    }
}
