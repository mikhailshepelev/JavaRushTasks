package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InputStream inStream = new FileInputStream(br.readLine());

        BufferedInputStream buffer = new BufferedInputStream(inStream);
//        FileReader fileReader = new FileReader(buffer);
//        BufferedReader bufferedReader = new BufferedReader(buffer);
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader r = new BufferedReader(
                new InputStreamReader(buffer, StandardCharsets.UTF_8));
        String line;
        while((line = r.readLine()) != null) {

//            String c = (String) buffer.read();
//            System.out.println(c);
            int a = Integer.parseInt(line);
            list.add(a);
        }
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i : list){
            if (i%2 == 0) newList.add(i);
        }
        Collections.sort(newList);
        for (int i : newList){
            System.out.println(i);
        }
        inStream.close();        // напишите тут ваш код
    }
}
