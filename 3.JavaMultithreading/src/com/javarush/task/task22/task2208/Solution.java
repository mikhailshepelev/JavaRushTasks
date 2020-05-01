package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> map: params.entrySet()) {
            if (map.getValue() != null) {
                sb.append(map.getKey() + " = '" + map.getValue() + "' and ");
            }
            }
        String result = sb.toString();
        if (result.endsWith(" and ")) result = result.substring(0, result.length()-5);
        return result;
        }
    }
