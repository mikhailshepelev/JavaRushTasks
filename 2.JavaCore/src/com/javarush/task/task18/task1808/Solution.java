package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        FileOutputStream outputStream1 = new FileOutputStream(file3);
        byte[] buffer = new byte[inputStream.available()];
        if (buffer.length%2 != 0){
            while (inputStream.available() > 0) {
                byte[] buffer1 = new byte[(buffer.length - 1) / 2 + 1];
                int count1 = inputStream.read(buffer1);
                outputStream.write(buffer1, 0, count1);
                byte[] buffer2 = new byte[inputStream.available()];
                int count2 = inputStream.read(buffer2);
                outputStream1.write(buffer2, 0, count2);
            }
        }
        else {
            while (inputStream.available() > 0) {
                byte[] buffer1 = new byte[buffer.length/2];
                int count1 = inputStream.read(buffer1);
                outputStream.write(buffer1, 0, count1);
                int count2 = inputStream.read(buffer1);
                outputStream1.write(buffer1, 0, count2);
            }
        }
        inputStream.close();
        outputStream.close();
        outputStream1.close();
    }
}
