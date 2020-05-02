package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String righside = "";
        for (int i = 0; i<url.length(); i++){
            if (url.charAt(i) == '?') righside = url.substring(i+1);
        }
        ArrayList<String> listOfParameters = new ArrayList<>(Arrays.asList(righside.split("&")));
        for (int i = 0; i<listOfParameters.size(); i++){
            ArrayList<String> insideParameter = new ArrayList<>(Arrays.asList(listOfParameters.get(i).split("=")));
            System.out.print(insideParameter.get(0) + " ");
        }
        for (String s : listOfParameters){
            if (s.contains("obj")){
                System.out.println();
                ArrayList<String> insideParameter = new ArrayList<>(Arrays.asList(s.split("=")));
                try {
                    double value = Double.parseDouble(insideParameter.get(1));
                    alert(value);
                }
                catch (Exception e){
                    alert(insideParameter.get(1));
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
