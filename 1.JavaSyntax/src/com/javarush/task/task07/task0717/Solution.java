package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
       ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<10; i++){
            String line = reader.readLine();
            list.add(line);
        }
        ArrayList<String> result = doubleValues(list);

        // Вывести на экран result
        for (String b : result) {
            System.out.println(b);
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i<list.size(); i++){
            a.add(list.get(i));
            a.add(list.get(i));
        }

        return a;
    }
}
