package com.javarush.task.task01.task0130;

/* 
Наш первый конвертер!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertCelsiusToFahrenheit(41));
    }

    public static double convertCelsiusToFahrenheit(int celsius) {
  // int fahrengeit = 5;
  // double fahrenheit = 9 / 5.0 * celsium + 32;
  // double fahr;
   //double c = celsius;
  //fahr = 9/5 * c + 32;
  double fahr = (celsius * 9.0 / 5) + 32;
  // celsius = (fahr - 32) * 5/9;
  // fahr = (celsius - (32*(5/9)))/(5/9);
  
        //напишите тут ваш код

        return fahr;
    }
}