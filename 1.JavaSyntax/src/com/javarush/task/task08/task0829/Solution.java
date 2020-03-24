package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<>();
        while (true) {
            String town = reader.readLine();
            if (town.isEmpty()) {
                break;
            }
            String family = reader.readLine();
            map.put(town,family);
        }

        // Read the house number

        String request = reader.readLine();
        for (Map.Entry entry: map.entrySet()) {
            if (request.equals(entry.getKey())) System.out.println(entry.getValue());
        }

//        int houseNumber = Integer.parseInt(reader.readLine());
//
//        if (0 <= houseNumber && houseNumber < list.size()) {
//            String familyName = list.get(houseNumber);
//            System.out.println(familyName);
//        }
    }
}
