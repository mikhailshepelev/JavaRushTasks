package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   String name1 = reader.readLine();    //напишите тут ваш код
int len1 = Integer.parseInt(name1);
String name2 = reader.readLine();
int len2 = Integer.parseInt(name2);
String name3 = reader.readLine();
int len3 = Integer.parseInt(name3);
if (len1<(len2+len3) && len2<(len1+len3) && len3<(len1+len2)) {
System.out.println("Треугольник существует."); }
else { System.out.println("Треугольник не существует."); }

//if (len1 >= (len2 + len3)) { if (len2 >= (len1 + len3)){ if (len3 >= (len1 + len2)) {
//System.out.println("Треугольник не существует."); }}}
    }
}