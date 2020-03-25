package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String stringFile1 = br.readLine();
            String stringFile2 = br.readLine();
            br = new BufferedReader(new FileReader(new File(stringFile1)));
            String st;
            if (br.ready()) {
                while ((st = br.readLine()) != null) {
                    allLines.add(st);
                }
            }
            br = new BufferedReader(new FileReader(new File(stringFile2)));
            String st1;
            if (br.ready()) {
                while ((st1 = br.readLine()) != null) {
                    forRemoveLines.add(st1);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            System.out.println(e);
        }
    }

    public void joinData() throws CorruptedDataException {
        int count = 0;
        for (int i = 0; i < forRemoveLines.size(); i++) {
            for (int j = 0; j < allLines.size(); j++) {
                if (allLines.get(j).equals(forRemoveLines.get(i))){
                    count++;
                    allLines.remove(j);
                    break;
                }
            }
        }
        if (count != forRemoveLines.size()) {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
