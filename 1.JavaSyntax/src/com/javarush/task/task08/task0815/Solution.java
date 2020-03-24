package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Иванова", "Александр");
        map.put("Петрова", "Евгений");
        map.put("Сидорова", "Петр");
        map.put("Иванов", "Евгений");
        map.put("Сидоров", "Александр");
        map.put("Петров", "Петр");
        map.put("Александрова", "Александр");
        map.put("Ивановаа", "Петр");
        map.put("Александров", "Петр");
        map.put("Петроваа", "Александр");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String value = pair.getValue();                  //значение
            if (value.equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String value = pair.getKey();                  //значение
            if (value.equals(lastName)) count++;
        }
        return count;

    }

    public static void main(String[] args) {

    }
}
