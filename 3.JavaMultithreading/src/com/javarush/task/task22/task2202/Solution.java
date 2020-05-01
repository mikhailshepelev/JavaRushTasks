package com.javarush.task.task22.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        String result = "";
            Pattern patt = Pattern.compile("\\s\\S*\\s\\S*\\s\\S*\\s\\S*");
            Matcher m = patt.matcher(string);
            if (m.find()) {
                result = string.substring(m.start()+1, m.end());
            }
            else throw new TooShortStringException();
        return result;
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
