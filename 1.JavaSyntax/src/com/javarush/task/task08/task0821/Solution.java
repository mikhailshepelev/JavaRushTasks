package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Александр");
        map.put("Петров", "Евгений");
        map.put("Сидоров", "Петр");
        map.put("Иванов", "Евгений");
        map.put("Сидоров", "Александр");
        map.put("Петров", "Петр");
        map.put("Александров", "Александр");
        map.put("Ивановаа", "Петр");
        map.put("Александров", "Петр");
        map.put("Петроваа", "Александр");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
