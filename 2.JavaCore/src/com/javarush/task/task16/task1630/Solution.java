package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName) throws FileNotFoundException;

        String getFileContent() throws IOException;

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        String fileName;
        List<String> listOfStrings = new ArrayList<>();

        @Override
        public void setFileName(String fullFileName) throws FileNotFoundException {
            fileName = fullFileName;
        }

        @Override
        public String getFileContent() throws IOException {
            String result = "";
            for (String s: listOfStrings) {
                result += s + " ";
            }
            return result;
        }

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
                String st;
                while ((st = br.readLine()) != null){
                    listOfStrings.add(st);}
                br.close();
                
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    }

