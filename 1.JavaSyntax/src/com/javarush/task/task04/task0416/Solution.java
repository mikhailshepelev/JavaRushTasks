package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   String a = reader.readLine();
   double t = Double.parseDouble(a);
   //напишите тут ваш код
double b = t%5;
if (b>=0&&b<3) System.out.println("зелёный");
else if (b>=3&&b<4) System.out.println("жёлтый");
else System.out.println("красный");

    
}}