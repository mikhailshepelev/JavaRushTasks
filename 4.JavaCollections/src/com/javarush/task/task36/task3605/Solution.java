package com.javarush.task.task36.task3605;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(new File(args[0]));
        Set<Character> set = new TreeSet<>();

        while (reader.ready()) {
            char c = (char) reader.read();
            if (Character.isLetter(c)) set.add(Character.toLowerCase(c));
        }
        reader.close();

        int counter = 0;
        for (Character c : set) {
            if (counter >= 5) break;
            System.out.print(c);
            counter++;
        }
    }
}
