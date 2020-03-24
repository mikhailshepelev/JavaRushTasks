package com.javarush.task.task07.task0716;

import java.lang.reflect.Array;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        for (int i = 0; i<strings.size(); i++) {
            String a = strings.get(i);
            if (a.contains("р") && a.contains("л")) {}
            else if (a.contains("р")) {strings.remove(i); i -=1;}
            else if (a.contains("л")) {strings.add(i,strings.get(i)); i +=1; }
        }
        return strings;
    }
}