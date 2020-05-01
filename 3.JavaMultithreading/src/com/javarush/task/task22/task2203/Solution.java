package com.javarush.task.task22.task2203;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        String result = "";
        Pattern patt = Pattern.compile("\\t[^\t]*\\t");
        Matcher m = patt.matcher(string);
        if (m.find()) {
            result = string.substring(m.start()+1, m.end()-1);
        }
        else throw new TooShortStringException();
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
