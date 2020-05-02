package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            FileReader fileReader = new FileReader(new File(Statics.FILE_NAME));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                 lines.add(line);
            }
            bufferedReader.close();
        } catch (Exception e){

        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
