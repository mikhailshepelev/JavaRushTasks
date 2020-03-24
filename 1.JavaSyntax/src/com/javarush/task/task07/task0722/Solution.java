package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; ; i++){
            String line = reader.readLine();
            if (line.equals("end")) {
                break;
            }
            list.add(line);
        }
        for (String a : list){
            System.out.println(a);
        }
        //напишите тут ваш код
    }
}