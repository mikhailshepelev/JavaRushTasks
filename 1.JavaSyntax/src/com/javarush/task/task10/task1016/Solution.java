package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (int i = 0; i<list.size();i++){
            result.put(list.get(i), 0);
        }
        int count = 0;
        for (Map.Entry<String, Integer> pair: result.entrySet()) {
            for (int j = 0; j<list.size(); j++){
                if (pair.getKey().equals(list.get(j))) {count++;}
            }
            pair.setValue(count);
            count = 0;
        }

        //напишите тут ваш код


        return result;
    }

}

