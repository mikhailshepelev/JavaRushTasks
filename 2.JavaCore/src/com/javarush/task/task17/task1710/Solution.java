package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        if (args[0].equals("-c")){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Person person;
            if (args[2].equals("м")){
                person = Person.createMale(args[1], dateFormat.parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
            else if (args[2].equals("ж")){
                person = Person.createFemale(args[1], dateFormat.parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
        }
        else if (args[0].equals("-u")){
            int index = Integer.parseInt(args[1]);
            Person person = allPeople.get(index);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            person.setName(args[2]);
            person.setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
            person.setBirthDate(dateFormat.parse(args[4]));
        }
        else if (args[0].equals("-d")){
            int index = Integer.parseInt(args[1]);
            Person person = allPeople.get(index);
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
        else if (args[0].equals("-i")){
            int index = Integer.parseInt(args[1]);
            Person person = allPeople.get(index);
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String sex = person.getSex() == Sex.MALE ? "м" : "ж";
            System.out.println(person.getName() + " " + sex + " " + dateFormat.format(person.getBirthDate()));
        }
        else System.out.println("incorrect input");
        //start
    }
}
