package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        switch (args[0]) {
            case ("-c") :
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i=i+3) {
                        Person person;
                        if (args[i+1].equals("м")){
                            person = Person.createMale(args[i], dateFormat1.parse(args[i+2]));
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                        else if (args[i+1].equals("ж")){
                            person = Person.createFemale(args[i], dateFormat1.parse(args[i+2]));
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                    }
                }
                break;
            case ("-u") :
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i=i+4) {
                        int index = Integer.parseInt(args[i]);
                        Person person = allPeople.get(index);
                        person.setName(args[i+1]);
                        person.setSex(args[i+2].equals("м") ? Sex.MALE : Sex.FEMALE);
                        person.setBirthDate(dateFormat1.parse(args[i+3]));
                    }
                }
                break;
            case ("-d") :
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        Person person = allPeople.get(index);
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                }
                break;
            case ("-i") :
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        Person person = allPeople.get(index);
                        String sex = person.getSex() == Sex.MALE ? "м" : "ж";
                        System.out.println(person.getName() + " " + sex + " " + dateFormat2.format(person.getBirthDate()));
                    }
                }
                break;
            default:
                System.out.println("incorrect input");
        }
        //start here - начни тут
    }
}
