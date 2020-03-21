package com.javarush.task.task04.task0424;

/* 
Три числа
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
if (a == b) System.out.print(3);
if (b == c) System.out.print(1);
if (a == c) System.out.print(2);

    }
}
