package com.javarush.task.task07.task0707;

import java.util.ArrayList;
import java.util.Scanner;
/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
        String s = "Mike";
        for (int i = 0; i<5; i++){
            list.add(i, s);
            s +=s;
        }
        System.out.println(list.size());
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
