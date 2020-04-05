package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = reader.readLine()) != null) {
            createPerson(line);
        }
        reader.close();
    }

    private static void createPerson(String line) throws ParseException {
        String [] splitForName = line.split("\\s\\d");
        String name = splitForName[0];
        String [] splitForDate = line.split("\\D\\s");
        String stringDate = splitForDate[splitForDate.length-1];
        DateFormat dateFormat = new SimpleDateFormat("d M yyyy", Locale.ENGLISH);
        Date date = dateFormat.parse(stringDate);
        Person person = new Person(name, date);
        PEOPLE.add(person);
    }
}
