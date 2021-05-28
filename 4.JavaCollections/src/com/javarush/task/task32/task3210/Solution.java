package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        randomAccessFile.seek(Integer.parseInt(args[1]));

        byte [] buffer = new byte[args[2].length()];
        randomAccessFile.read(buffer, 0, args[2].length());
        String textFromFile = new String(buffer);

        randomAccessFile.seek(randomAccessFile.length());
        if (textFromFile.equals(args[2])) {
            randomAccessFile.write("true".getBytes());
        } else {
            randomAccessFile.write("false".getBytes());
        }
    }
}
