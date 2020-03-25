package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        List<Integer> list = new ArrayList<>();
        try {
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int a = Integer.parseInt(reader.readLine());
                list.add(a);
            }
        }
        catch (Exception e){
            for (Integer b : list){
                System.out.println(b);
            }
        }

        //напишите тут ваш код
    }
}
