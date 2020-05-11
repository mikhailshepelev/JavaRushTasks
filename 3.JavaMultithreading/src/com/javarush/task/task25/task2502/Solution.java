package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            wheels = new ArrayList<>();
            String [] array = loadWheelNamesFromDB();
            if (array.length != 4) throw new Exception();
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(String.valueOf(Wheel.FRONT_LEFT))) wheels.add(Wheel.FRONT_LEFT);
                else if (array[i].equals(String.valueOf(Wheel.FRONT_RIGHT))) wheels.add(Wheel.FRONT_RIGHT);
                else if (array[i].equals(String.valueOf(Wheel.BACK_LEFT))) wheels.add(Wheel.BACK_LEFT);
                else if (array[i].equals(String.valueOf(Wheel.BACK_RIGHT))) wheels.add(Wheel.BACK_RIGHT);
                else throw new Exception();
            }
            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
