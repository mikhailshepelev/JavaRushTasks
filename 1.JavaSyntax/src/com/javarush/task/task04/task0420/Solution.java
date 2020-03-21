package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
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

if ((a>b&&a>c) && b>c) System.out.print(a + " " + b + " " + c);
if ((b>a&&b>c) && a>c) System.out.print(b + " " + a + " " + c);
if ((a>b&&a>c) && c>b) System.out.print(a + " " + c + " " + b);
if ((b>a&&b>c) && c>a) System.out.print(b + " " + c + " " + a);
if ((c>a&&c>b) && a>b) System.out.print(c + " " + a + " " + b);
if ((c>a&&c>b) && b>a) System.out.print(c + " " + b + " " + a);
if (a==b&&a>c) System.out.print(a + " " + b + " " + c);
if (a==b&&a<c) System.out.print(c + " " + b + " " + a);
if (a==c&&a>b) System.out.print(a + " " + c + " " + b);
if (a==c&&a<b) System.out.print(b + " " + c + " " + a);
if (b==c&&a>b) System.out.print(a + " " + c + " " + b);
if (b==c&&a<b) System.out.print(b + " " + c + " " + a);
if (a==b&&a==c) System.out.print(b + " " + c + " " + a);
    //напишите тут ваш код

    }
}
