package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<>();
        int[] arr1 = new int[5];
        list.add(arr1);
        int[] arr2 = new int[2];
        list.add(arr2);
        int[] arr3 = new int[4];
        list.add(arr3);
        int[] arr4 = new int[7];
        list.add(arr4);
        int[] arr5 = new int[0];
        list.add(arr5);
        for (int [] a : list){
            for (int b = 0; b<a.length; b++){
                a[b] = 44;
            }
        }
        return list;
        //напишите тут ваш код
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
