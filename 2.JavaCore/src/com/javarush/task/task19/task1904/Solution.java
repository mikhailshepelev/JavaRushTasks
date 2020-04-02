package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner(System.in));
        Person person = personScannerAdapter.read();
        System.out.println(person.toString());

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String line = fileScanner.nextLine();
            String [] array = line.split(" ", 4);
            SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy");
            Date date = df.parse(array[3]);
            return new Person(array[1], array[2], array[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
