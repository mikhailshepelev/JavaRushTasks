package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 20 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);

        Date date1 = df.parse(date);

        Calendar calendar1 = new GregorianCalendar();
        calendar1.setTime(date1);
//        System.out.println(calendar1.getTime());
        int a = calendar1.get(Calendar.DAY_OF_YEAR);
        if (a%2 != 0) return true;
        else return false;
    }
}
