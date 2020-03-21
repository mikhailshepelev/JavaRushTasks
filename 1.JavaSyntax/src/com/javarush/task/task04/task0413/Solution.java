package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   String name = reader.readLine();    //напишите тут ваш код
int day = Integer.parseInt(name);
if (day == 1) { System.out.print("понедельник");}
if (day == 2) { System.out.print("вторник");}
if (day == 3) { System.out.print("среда");}
if (day == 4) { System.out.print("четверг");}
if (day == 5) { System.out.print("пятница");}
if (day == 6) { System.out.print("суббота");}
if (day == 7) { System.out.print("воскресенье");} 
if (day < 1) { System.out.print("такого дня недели не существует"); }
if (day > 7) { System.out.print("такого дня недели не существует"); }
    }
}