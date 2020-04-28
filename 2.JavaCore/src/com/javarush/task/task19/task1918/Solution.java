package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        StringBuilder builder = new StringBuilder();
        while (fileReader.ready()) {
            int data = fileReader.read();
            builder.append((char) data);
        }
        fileReader.close();
        String result = builder.toString();

        Document dc = Jsoup.parse(result," ", Parser.xmlParser());
        Elements elem = dc.select(args[0]);

        for (Element elements: elem){
            System.out.println(elements);
        }
    }
}
