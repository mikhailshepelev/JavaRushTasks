package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();
        FileOutputStream outputStream = new FileOutputStream(file1);
        FileInputStream inputStream1 = new FileInputStream(file2);
        FileInputStream inputStream2 = new FileInputStream(file3);
            while (inputStream1.available() > 0) {
                byte[] buffer = new byte[inputStream1.available()];
                inputStream1.read(buffer);
                outputStream.write(buffer);
            }
        outputStream = new FileOutputStream(file1, true);
            while (inputStream2.available() > 0) {
            byte[] buffer = new byte[inputStream2.available()];
            inputStream2.read(buffer);
            outputStream.write(buffer);
            }
        inputStream1.close();
        inputStream2.close();
        outputStream.close();
    }
}
