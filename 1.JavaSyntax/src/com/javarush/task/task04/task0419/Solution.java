package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
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
String name4 = reader.readLine();
int d = Integer.parseInt(name4);
if (a>=b && a>=c && a>=d) System.out.print(a);
else if (b>=a && b>=c && b>=d) System.out.print(b);
else if (c>=b && c>=a && c>=d) System.out.print(c);
else if (d>=a && d>=b && d>=c) System.out.print(d);
else System.out.print(a);
//напишите тут ваш код

    }
}
