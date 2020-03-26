package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PersonService {
    public static void createPerson(String input) throws ParseException {
        String[] array = input.split(" ");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person;
        if (array[2].equals("м")){
            person = Person.createMale(array[1], dateFormat.parse(array[3]));
            Solution.allPeople.add(person);
            System.out.println(Solution.allPeople.indexOf(person));
        }
        else if (array[2].equals("ж")){
            person = Person.createFemale(array[1], dateFormat.parse(array[3]));
            Solution.allPeople.add(person);
            System.out.println(Solution.allPeople.indexOf(person));
        }
    }

    public static void updatePerson(String input) throws ParseException {
        String[] array = input.split(" ");
        int index = Integer.parseInt(array[1]);
        Person person = Solution.allPeople.get(index);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        person.setName(array[2]);
        person.setSex(array[3].equals("м") ? Sex.MALE : Sex.FEMALE);
        person.setBirthDate(dateFormat.parse(array[4]));
    }

    public static void deletePerson(String input){
        String[] array = input.split(" ");
        int index = Integer.parseInt(array[1]);
        Person person = Solution.allPeople.get(index);
        person = null;
    }

    public static void showPerson(String input){
        String[] array = input.split(" ");
        int index = Integer.parseInt(array[1]);
        Person person = Solution.allPeople.get(index);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(person.getName() + " " + person.getSex() + " " + dateFormat.format(person.getBirthDate()));
    }
}
