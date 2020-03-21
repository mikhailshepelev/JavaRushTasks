package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   String name1 = reader.readLine();    //напишите тут ваш код
int a = Integer.parseInt(name1);
String name2 = reader.readLine();
int b = Integer.parseInt(name2);
String name3 = reader.readLine();
int c = Integer.parseInt(name3);       //напишите тут ваш код
if (a==b) { if (b==c) { System.out.print(a + " " + b + " " + c);} if (b!=c) {
System.out.print(a + " " + b); }}
if (b==c) { if (a!=b) { System.out.print(b + " " + c); }}
if (a==c) { if (a!=b){  System.out.print(a + " " + c); }}

    }
}