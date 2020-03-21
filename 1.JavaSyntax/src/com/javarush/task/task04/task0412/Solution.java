package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   String name = reader.readLine();
   int number = Integer.parseInt(name);
   
   if (number == 0) {
       System.out.print(number);
   }
   if  (number > 0) {
       System.out.print(number*2);
   }
   if (number < 0) {
       System.out.print(number+1);
   }
} }