package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
        }
    }
    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line.equals(Planet.EARTH)) thePlanet = Earth.getInstance();
        else if (line.equals(Planet.MOON)) thePlanet = Moon.getInstance();
        else if (line.equals(Planet.SUN)) thePlanet = Sun.getInstance();
        else thePlanet = null;
        // implement step #5 here - реализуйте задание №5 тут
    }
}
