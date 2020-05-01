package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        List<String> listOfWords = new ArrayList<>();
        String line = "";
        while ((line = fileReader.readLine()) != null) {
            String[] array = line.split("\\s");
            listOfWords.addAll(Arrays.asList(array));
        }
        fileReader.close();
        List<Pair> tempList = new LinkedList<>();
            for (String s : listOfWords) {
                StringBuilder sb = new StringBuilder(s);
                String revertedString = sb.reverse().toString();
                if (revertedString.equals(s)) {
                    int count = 0;
                    for (int i = 0; i < listOfWords.size(); i++) {
                        if (listOfWords.get(i).equals(s)) count++;
                        if (count > 1) {
                            Pair pair = new Pair();
                            pair.first = s;
                            pair.second = s;
                            if (!tempList.contains(pair)) tempList.add(pair);
                        }
                    }
                }
                else if (listOfWords.contains(revertedString)) {
                    Pair pair = new Pair();
                    pair.first = s;
                    pair.second = revertedString;
                    if (!tempList.contains(pair)) tempList.add(pair);
                }
            }
        for (Pair p: tempList) {
            Pair pair = new Pair();
            pair.first = p.second;
            pair.second = p.first;
            if (!result.contains(pair)) result.add(p);
        }
        for (Pair p: result) {
            System.out.println(p.toString());
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

                @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
