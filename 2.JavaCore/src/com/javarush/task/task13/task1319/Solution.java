package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in); // поток чтения с консоли
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  // соединяем InputStreamReader с BufferedReader

        File file = new File(bufferedReader.readLine());
        FileWriter fileWriter = new FileWriter(file); // поток, который подключается к текстовому файлу
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // соединяем FileWriter с BufferedWriter

        String line;
        while(true) {
            line = bufferedReader.readLine();
            bufferedWriter.write(line + "\n");
            if (line.equals("exit")) break;
        }

        bufferedReader.close(); // закрываем поток
        bufferedWriter.close(); // закрываем поток
    }
}
