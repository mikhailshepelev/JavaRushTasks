package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        }
        catch (ArithmeticException b){
            exceptions.add(b);
        }
        try {
            int [] array = new int[2];
            array[3] = 1;
        }
        catch (ArrayIndexOutOfBoundsException a){
            exceptions.add(a);
        }
        try {
            int a = Integer.parseInt(null);
        }
        catch (NumberFormatException c){
            exceptions.add(c);
        }
        try {
            Number[] a = new Double[2];
            a[0] = new Integer(4);
        }
        catch (ArrayStoreException t){
            exceptions.add(t);
        }
        try {
            throw new IndexOutOfBoundsException();
        }
        catch (IndexOutOfBoundsException d){
            exceptions.add(d);
        }
        try {
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException f){
            exceptions.add(f);
        }
        try {
            throw new RuntimeException();
        }
        catch (RuntimeException g){
            exceptions.add(g);
        }
        try {
            throw new Exception();
        }
        catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new FileNotFoundException();
        }
        catch (FileNotFoundException h){
            exceptions.add(h);
        }
        try {
            throw new IOException();
        }
        catch (IOException j){
            exceptions.add(j);
        }


        //напишите тут ваш код

    }
}
