package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
    }

    static {
        try {
            reset();
        } catch (IOException e) {
        }
        //add your code here - добавьте код тут
    }

    public static CanFly result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if (input.equals("helicopter")) result = new Helicopter();
        else if (input.equals("plane")) {
            int amount = Integer.parseInt(reader.readLine());
            result = new Plane(amount);
        }
        reader.close();
        //add your code here - добавьте код тут
    }
}
