package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length != 4) return;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String line;
            List<Integer> listOfIDS = new ArrayList<>();
            while ((line = fileReader.readLine()) != null) {
                String id = line.substring(0, 8);
                StringBuilder targetedID = new StringBuilder();
                for (int i = 0; i < id.length(); i++) {
                    if (id.charAt(i) == ' ') break;
                    else targetedID.append(id.charAt(i));
                }
                listOfIDS.add(Integer.parseInt(targetedID.toString()));
            }
            fileReader.close();

            Collections.sort(listOfIDS);
            int idToPut = listOfIDS.get(listOfIDS.size() - 1) + 1;
            String id = Integer.toString(idToPut);
            String formattedID = getFormattedString(id, 8);

            if (args[0].equals("-c")) {
                String productName = getFormattedString(args[1], 30);
                String price = getFormattedString(args[2], 8);
                String quantity = getFormattedString(args[3], 4);
                String entireString = "\n" + formattedID + productName + price + quantity;

                FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
                fileOutputStream.write(entireString.getBytes());
                fileOutputStream.close();
            }
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
