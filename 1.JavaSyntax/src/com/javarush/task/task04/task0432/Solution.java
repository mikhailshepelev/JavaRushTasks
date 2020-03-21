package com.javarush.task.task04.task0432;

/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
String name1 = reader.readLine();
String name2 = reader.readLine();
int a = Integer.parseInt(name2);
while (a>0) {
    System.out.println(name1);
    a--;
}

//напишите тут ваш код

    }
}
