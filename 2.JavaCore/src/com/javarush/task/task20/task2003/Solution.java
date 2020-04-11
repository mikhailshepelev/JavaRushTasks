package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
        OutputStream outputStream = new FileOutputStream(fileName);
        save(outputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties props = new Properties();
        props.putAll(properties);
        props.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        properties.putAll((Map)prop);
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
    }
}
