package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int a = 0; a<alphabet.size(); a++) {
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                char[] array = list.get(i).toCharArray();
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == alphabet.get(a)) {count++;}
                }
            }
            map.put(alphabet.get(a), count);
        }
        for (int i = 0; i<alphabet.size(); i++) {
            for (Map.Entry<Character, Integer> pair : map.entrySet()) {
                if (alphabet.get(i) == pair.getKey()) {
                System.out.println(pair.getKey() + " " + pair.getValue()); }
            }
        }
        // напишите тут ваш код
    }
}
