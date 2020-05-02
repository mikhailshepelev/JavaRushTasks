package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.equals("")) return false;
        char [] charArray = telNumber.toCharArray();
        int digitsCount = 0;
        for (char c: charArray) {
            if (Character.isDigit(c)) digitsCount++;
        }
        if (telNumber.startsWith("+") && digitsCount == 12) {
            Pattern pattern = Pattern.compile("\\+\\d*(\\(\\d{3}\\))?\\d*-?\\d+-?\\d+-?\\d+");
            Matcher matcher = pattern.matcher(telNumber);
            return matcher.matches();
        }
        else if ((Character.isDigit(charArray[0]) || charArray[0] == '(') && digitsCount == 10) {
            Pattern pattern = Pattern.compile("\\d*(\\(\\d{3}\\))?\\d*-?\\d+-?\\d+-?\\d+");
            Matcher matcher = pattern.matcher(telNumber);
            return matcher.matches();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
    }
}
