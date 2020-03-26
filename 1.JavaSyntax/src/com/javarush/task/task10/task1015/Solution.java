package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String> [] array = new ArrayList[3];
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        array[0] = list1;
        array[1] = list2;
        array[2] = list3;
        String text1 = "De Rossi";
        String text2 = "Totti";
        String text3 = "Pellegrini";
        list1.add(text1);
        list1.add(text2);
        list1.add(text3);
        list2.add(text1);
        list2.add(text2);
        list2.add(text3);
        list3.add(text1);
        list3.add(text2);
        list3.add(text3);
        //напишите тут ваш код

        return array;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}