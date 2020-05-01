package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String str;
        List<String> list = new ArrayList<>();
        while ((str = fileReader.readLine()) != null) {
            String [] array = str.split("\\s");
            list.addAll(Arrays.asList(array));
        }
        fileReader.close();
        String[] array = new String[list.size()];
        array = list.toArray(array);
        StringBuilder result = getLine(array);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words.length == 0) return sb;
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(words));
        sb = sb.append(list.get(0));
        list.remove(0);
        int counter = 0;
        while (!list.isEmpty()){
            String lastSB = sb.substring(sb.length()-1);
            String firstSB = sb.substring(0, 1);
            String firstList = list.get(0).substring(0, 1);
            String lastList = list.get(0).substring(list.get(0).length()-1);
            if (lastSB.equalsIgnoreCase(firstList)) {
                sb = sb.append(" " + list.get(0));
                list.remove(0);
                counter = 0;
            }
            else if (firstSB.equalsIgnoreCase(lastList)) {
                sb = sb.insert(0, list.get(0) + " ");
                list.remove(0);
                counter = 0;
            }
            else {
                String word = list.get(0);
                list.remove(0);
                list.add(word);
                counter++;
            }
            if (counter >= list.size()) {
                for (int i = 0; i < list.size(); i++) {
                    sb.append(" " + list.get(i));
                }
                break;
            }
        }
        return sb;
    }
}
