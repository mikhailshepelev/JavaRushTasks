package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SortedMap<Integer, String> map = new TreeMap<>();
        String line = "";
        String fileNameWithoutSuffix = "";
        while (!(line = reader.readLine()).equals("end")) {
            String[] splitedString = line.split(".part");
            fileNameWithoutSuffix = splitedString[0];
            try {
                int number = Integer.parseInt(splitedString[splitedString.length - 1]);
                map.put(number, line);
            } catch (Exception e){
                System.out.println(e);
            }
        }
        reader.close();
        System.out.println(fileNameWithoutSuffix);

        File f = new File(fileNameWithoutSuffix);
        f.createNewFile();

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(f));
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(pair.getValue()));
            byte [] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            outputStream.write(buffer);
            inputStream.close();
        }
        outputStream.close();
    }
}
