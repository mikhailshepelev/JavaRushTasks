package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        InputStream inStream = new FileInputStream(line);

        BufferedInputStream buffer = new BufferedInputStream(inStream);

        while (buffer.available() > 0) {

            char c = (char) buffer.read();

            System.out.print(c);


        }
        inStream.close();
        reader.close();
    }

}