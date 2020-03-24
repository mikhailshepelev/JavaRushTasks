package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i<20; i++){
        String line = reader.readLine();
        int a = Integer.parseInt(line);
        list.add(a);
    }
    ArrayList<Integer> three = new ArrayList<>();
    ArrayList<Integer> two = new ArrayList<>();
    ArrayList<Integer> other = new ArrayList<>();
    for (int i = 0; i<list.size(); i++){
        if (list.get(i)%3 == 0) {three.add(list.get(i));}
        if (list.get(i)%2 == 0) {two.add(list.get(i));}
        if (list.get(i)%3 !=0 && list.get(i)%2 != 0) {other.add(list.get(i));}
    }
    Solution.printList(three);
        Solution.printList(two);
        Solution.printList(other);
    }
    public static void printList(ArrayList<Integer> list) {
//    ArrayList<Integer> temp = new ArrayList<>();
    for (int i = 0; i<list.size(); i++) {
        System.out.println(list.get(i));
    }
    }
}
