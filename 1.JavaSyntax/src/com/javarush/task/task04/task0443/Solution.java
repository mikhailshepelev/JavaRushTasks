package com.javarush.task.task04.task0443;

/* 
Как назвали, так назвали
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

String name = reader.readLine();
String year = reader.readLine();
int a = Integer.parseInt(year);    //напишите тут ваш код
String month = reader.readLine();
int b = Integer.parseInt(month); 
String day = reader.readLine();
int c = Integer.parseInt(day); 
System.out.println("Меня зовут " + name + ".");
System.out.println("Я родился " + c + "." + b + "." + a);
    }
}
