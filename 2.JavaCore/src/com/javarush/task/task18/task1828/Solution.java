package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 5 && args.length != 2) return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        List<String> listOfLines = new ArrayList<>();
        while ((line = fileReader.readLine()) != null) {
            String id = line.substring(0, 8);
            StringBuilder targetedID = new StringBuilder();
            for (int i = 0; i < id.length(); i++) {
                if (id.charAt(i) == ' ') break;
                else targetedID.append(id.charAt(i));
            }
            int intID = Integer.parseInt(targetedID.toString());
            if (args[0].equals("-d") && Integer.parseInt(args[1]) == intID) {
            }
            else if (args[0].equals("-u") && Integer.parseInt(args[1]) == intID) {
                String productName = getFormattedString(args[2], 30);
                String price = getFormattedString(args[3], 8);
                String quantity = getFormattedString(args[4], 4);
                String entireString = id + productName + price + quantity;
                listOfLines.add(entireString);
            }
            else {
                listOfLines.add(line);
            }
        }
        fileReader.close();

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < listOfLines.size(); i++) {
            fileWriter.write(listOfLines.get(i) + "\n");
        }

        fileWriter.close();
    }

    public static String getFormattedString(String input, int targetedCapacity) {
        int howManySpacesToAdd = targetedCapacity - input.length();
        String formattedString = "";
        StringBuilder builder = new StringBuilder();
        if (howManySpacesToAdd > 0) {
            builder.append(input);
            for (int i = 0; i < howManySpacesToAdd; i++) {
                builder.append(" ");
            }
            formattedString = builder.toString();
        }
        else if (howManySpacesToAdd == 0) {
            builder.append(input);
            formattedString = builder.toString();
        }
        else {
            formattedString = input.substring(0, targetedCapacity);
        }
        return formattedString;
    }
    }
