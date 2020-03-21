package com.javarush.task.task04.task0428;

/* 
Положительное число
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

if (a>0 && b>0 && c>0) System.out.print(3);
if (a<=0 && b>0 && c>0) System.out.print(2);
if (a>0 && b<=0 && c>0) System.out.print(2);
if (a>0 && b>0 && c<=0) System.out.print(2);
if (a<=0 && b<=0 && c>0) System.out.print(1);
if (a>0 && b<=0 && c<=0) System.out.print(1);
if (a<=0 && b>0 && c<=0) System.out.print(1);
if (a<=0 && b<=0 && c<=0) System.out.print(0);
        //напишите тут ваш код

    }
}
