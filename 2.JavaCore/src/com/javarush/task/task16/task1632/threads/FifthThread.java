package com.javarush.task.task16.task1632.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FifthThread extends Thread {
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
            try {
                while (true) {
                    String line = reader.readLine();
                    if (line.equals("N")) break;
                    int temp = Integer.parseInt(line);
                    result += temp;
                }
                System.out.println(result);
            } catch (IOException e) {
            }
        }
    }

