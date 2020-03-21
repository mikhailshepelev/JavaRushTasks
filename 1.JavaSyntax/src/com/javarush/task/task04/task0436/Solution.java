package com.javarush.task.task04.task0436;

/* 
Рисуем прямоугольник
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
String name1 = reader.readLine();
int m = Integer.parseInt(name1);
String name2 = reader.readLine();
int n = Integer.parseInt(name2);
for (int b=0; b<m; b++) {
for (int a=0; a<n; a++){
    System.out.print("8");
}
System.out.println("");
}
}}
