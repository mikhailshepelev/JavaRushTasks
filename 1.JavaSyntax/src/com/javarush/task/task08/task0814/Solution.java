package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            int a = rand.nextInt();
            set.add(a);
        }
        return set;

        //получение итератора для множества
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Set<Integer> set2 = new HashSet<Integer>();
        for (Integer nums : set)
        {
            if (nums>10) {set2.add(nums);}
        }
        set.removeAll(set2);
        return set;

    }

    public static void main(String[] args) {
//        createSet();
//        Set<Integer> set = removeAllNumbersGreaterThan10(createSet());
//        Iterator<Integer> iterator = set.iterator();
//        while (iterator.hasNext())        //проверка, есть ли ещё элементы
//        {
//            //получение текущего элемента и переход на следующий
//            int num = iterator.next();
//            System.out.println(num);
//        }
    }
}
