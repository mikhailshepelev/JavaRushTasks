package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        List<Byte> password = new ArrayList<>();

        while (password.size() < 9) {
            password.add(getRandomNumber(65, 90));
            password.add(getRandomNumber(97, 122));
            password.add(getRandomNumber(48, 57));
        }
        int randomNumber = getRandomNumber(0, 8);
        password.remove(randomNumber);
        Collections.shuffle(password);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(password.size());
        for (byte b : password) {
            byteArrayOutputStream.write(b);
        }

        return byteArrayOutputStream;
    }

    private static Byte getRandomNumber(int min, int max) {
        return (byte) ((Math.random() * (max - min)) + min);
    }
}
