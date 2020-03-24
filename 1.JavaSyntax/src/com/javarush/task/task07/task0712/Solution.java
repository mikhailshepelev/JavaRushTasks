package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> mins = new ArrayList<String>();
        ArrayList<String> maxs = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line);
        }
        int temp = 2147483645;
        for (int i = 0; i < list.size(); i++) {
            String m = list.get(i);
            if (m.length() < temp) {
                temp = m.length();
                mins.clear();
                mins.add(m);
            } else if (m.length() == temp) {
                mins.add(m);
                temp = m.length();
            }
        }
        int temp1 = -2147483648;
        for (int i = 0; i<list.size(); i++){
            String m = list.get(i);
            if (m.length()>temp1){temp1 = m.length(); maxs.clear(); maxs.add(m);}
            else if (m.length() == temp1){maxs.add(m); temp1 = m.length();}
        }
        for (String a : list){
            if (a.equals(mins.get(0))) {
                System.out.println(a);
                break;
            }
            else if (a.equals(maxs.get(0))) {
                System.out.println(a);
                break;
            }
        }
    }
}
