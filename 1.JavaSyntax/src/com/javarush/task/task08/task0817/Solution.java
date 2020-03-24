package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> copy = new HashMap<>(map);
        Set<String> set = new HashSet<>();
        for (String name : copy.values()) {
            if (!set.add(name)) {
                removeItemFromMapByValue(map, name);
            }
        }


    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
//        Map<String, String> a = createMap();
//        removeTheFirstNameDuplicates(a);
    }
}
