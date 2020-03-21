package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
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
if (a<b) System.out.print(a);
else System.out.print(b);
//напишите тут ваш код

    }
}