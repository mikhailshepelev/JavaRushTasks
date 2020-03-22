package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
    Scanner sc1 = new Scanner(System.in);
    String name = sc1.nextLine();
    return name;
    }

    public static int readInt() throws Exception {
    Scanner sc2 = new Scanner(System.in);
    int a = sc2.nextInt();
    return a;
    }

    public static double readDouble() throws Exception {
    Scanner sc3 = new Scanner(System.in);
    double n = sc3.nextDouble();
    return n;
    }

    public static boolean readBoolean() throws Exception {
    Scanner sc4 = new Scanner(System.in);
    String name = sc4.nextLine();
    boolean a;
    if (name.equals("true")) {a = true;}
    else a = false;
    return a;
    }

    public static void main(String[] args) throws Exception {

    }
}
