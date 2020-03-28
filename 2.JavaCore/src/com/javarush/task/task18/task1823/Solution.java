package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {

        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                Map<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < 128; i++) {
                    map.put(i, 0);
                }
                while (inputStream.available() > 0) {
                    int i = inputStream.read();
                    for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                        if (i == pair.getKey()){
                            pair.setValue(pair.getValue() + 1);
                            break;
                        }
                    }
                }

                inputStream.close();

                int maxValue = Integer.MIN_VALUE;
                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    if (pair.getValue()>maxValue){
                        maxValue = pair.getValue();
                    }
                }
                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    if (pair.getValue() == maxValue) {
                        resultMap.put(fileName, pair.getKey());
;                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}
