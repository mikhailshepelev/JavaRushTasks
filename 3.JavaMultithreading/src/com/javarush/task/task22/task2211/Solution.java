package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);

        Charset win1251 = Charset.forName("Windows-1251");
        Charset utf8 = StandardCharsets.UTF_8;

        byte[] buffer = new byte[inputStream.available()];
        while (inputStream.available() > 0) {
            inputStream.read(buffer);
        }
        inputStream.close();
        String s = new String(buffer, win1251);
        buffer = s.getBytes(utf8);
        outputStream.write(buffer);
        outputStream.close();
    }
}
