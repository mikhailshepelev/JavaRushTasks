package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Random rd = new Random();
        String s = "Mike ";
        for (int i = 0; i<10; i++){
            map.put(s, rd.nextInt());
            s+=s;
        }
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, Integer> pair = iterator.next();
            String key = pair.getKey();            //ключ
            Integer value = pair.getValue();
            if (value<500) iterator.remove();
        }
    }

    public static void main(String[] args) {
//        Map<String, Integer> map1 = createMap();
//        removeItemFromMap(createMap());
//        for (Map.Entry<String, Integer> pair : map1.entrySet())
//        {
//            String key = pair.getKey();                      //ключ
//            Integer value = pair.getValue();                  //значение
//            System.out.println(key + ":" + value);
//        }
    }
}