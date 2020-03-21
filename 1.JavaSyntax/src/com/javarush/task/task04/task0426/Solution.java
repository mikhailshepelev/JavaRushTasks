package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
String name = reader.readLine();
int a = Integer.parseInt(name); 
int b = a%2;
if (b!=0 && a<0) System.out.print("отрицательное нечетное число");
if (b!=0 && a>0) System.out.print("положительное нечетное число");
if (b==0 && a>0) System.out.print("положительное четное число");
if (b==0 && a<0) System.out.print("отрицательное четное число");
if (a==0) System.out.print("ноль");


    }
}
