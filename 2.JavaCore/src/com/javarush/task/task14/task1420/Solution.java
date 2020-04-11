package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = reader.readLine();
        String line2 = reader.readLine();
        
        int a = 0;
        int b = 0;
        
        a = Integer.parseInt(line1);
        b = Integer.parseInt(line2);
        
        if (a<=0 || b<= 0) throw new Exception("b");
        
        int divider = 1;
        for (int i = 1; ; i++){
            if (a%i == 0 && b%i == 0){divider = i;}
            if (i >a && i>b) break;
        }
        System.out.println(divider);
    
    }
}
