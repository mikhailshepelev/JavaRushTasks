package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String sAge = reader.readLine();
            int a = Integer.parseInt(sAge);
            list.add(a);
        }
        ArrayList<Integer> count = new ArrayList<>();
        int a = 1;
        count.add(a);
        for (int i = 1; i<list.size(); i++){
            int c = list.get(i);
            int d = list.get(i-1);
            if (c == d) {a++;}
            else { count.add(a);
            a =1;}
        }
        count.add(a);
        int max = count.get(0);
        for (int i = 1; i<count.size(); i++){
            if (count.get(i)>=max) {max = count.get(i);}
        }
        System.out.println(max);
    }
}