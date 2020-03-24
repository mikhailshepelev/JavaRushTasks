package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Шварценеггер", dateFormat.parse("JUN 22 1955"));
        map.put("Алехандро", dateFormat.parse("JAN 31 1987"));
        map.put("Стэтхем", dateFormat.parse("FEB 26 1976"));
        map.put("Фаррелл", dateFormat.parse("JUL 5 1966"));
        map.put("Майкл", dateFormat.parse("APR 15 1970"));
        map.put("Мортенсен", dateFormat.parse("MAR 20 1989"));
        map.put("Ренник", dateFormat.parse("DEC 10 1997"));
        map.put("Бонд", dateFormat.parse("NOV 8 1900"));
        map.put("Пуаро", dateFormat.parse("OCT 4 1940"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        map.entrySet().removeIf(pair -> pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8);

    }

    public static void main(String[] args) throws ParseException {

    }
}
