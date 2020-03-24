package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = reader.readLine();
        int n = Integer.parseInt(line1);
        String line2 = reader.readLine();
        int m = Integer.parseInt(line2);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i<n; i++){
            String line = reader.readLine();
            list.add(line);
        }
        for (int i = 0; i<m; i++){
            String item = list.get(0);

            list.add(item);
            list.remove(0);
        }
        for (String a : list){
            System.out.println(a);
        }
        //напишите тут ваш код
    }
}
