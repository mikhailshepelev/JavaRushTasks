package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   String name1 = reader.readLine();   
int a = Integer.parseInt(name1);
String name2 = reader.readLine();   
int b = Integer.parseInt(name2);  
String name3 = reader.readLine();   
int c = Integer.parseInt(name3);  
int d, e;
if (a==0 && b==0 && c==0) { d = 0; e = 0; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a==0 && b==0 && c>0) { d = 1; e = 0; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a==0 && b==0 && c<0){ d = 0; e = 1; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a==0 && b<0 && c==0) { d = 0; e = 1; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a<0 && b==0 && c==0) { d = 0; e = 1; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a==0 && b>0 && c==0) { d = 1; e = 0; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a>0 && b==0 && c==0) { d = 1; e = 0; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if ((a==0 && b>0 && c>0) || (b==0 && a>0 && c>0) || (c==0 && a>0 && b>0)) { d = 2; e = 0; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if ((a==0 && b<0 && c<0) || (b==0 && a<0 && c<0) || (c==0 && a<0 && b<0)) { d = 0; e = 2; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if ((a==0 && b>0 && c<0) || (a>0 && b==0 && c<0) || (a==0 && b<0 && c>0) || (a<0 && b==0 && c>0) || (a>0 && b<0 && c==0) || (a<0 && b>0 && c==0)) {d = 1; e = 1; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}

if (a>0 && b>0 && c>0) { d = 3; e = 0; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a<0 && b<0 && c<0) { d = 0; e = 3; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a>0 && b>0 && c<0) { d = 2; e = 1; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a>0 && b<0 && c>0) { d = 2; e = 1; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a<0 && b>0 && c>0) { d = 2; e = 1; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a>0 && b<0 && c>0) { d = 1; e = 2; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a>0 && b<0 && c<0) { d = 1; e = 2; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a<0 && b>0 && c<0) { d = 1; e = 2; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
if (a<0 && b<0 && c>0) { d = 1; e = 2; System.out.println("количество положительных чисел: " + d); System.out.print("количество отрицательных чисел: " + e);}
}}

