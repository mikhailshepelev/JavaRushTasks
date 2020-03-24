package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;
        int [] nums = new int[20];
        for (int i = 0; i<nums.length; i++){
            String line = reader.readLine();
            nums [i] = Integer.parseInt(line);
        }
        maximum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= maximum) {
                maximum = nums[i];
            }
        }
        minimum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= minimum) {
                minimum = nums[i];
            }
        }
        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}
