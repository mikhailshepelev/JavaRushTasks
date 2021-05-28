package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");

        int targetedPosition = Integer.parseInt(args[1]);

        if (randomAccessFile.length() < targetedPosition) {
            randomAccessFile.seek(randomAccessFile.length());
        } else {
            randomAccessFile.seek(targetedPosition);
        }

        randomAccessFile.write(args[2].getBytes());

    }
}
