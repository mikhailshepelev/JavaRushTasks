package com.javarush.task.task30.task3001;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* 
Конвертер систем счислений
*/

public class Solution {

    private static List<Character> list = new ArrayList<>();

    static {
        list.add('0');
        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');
        list.add('8');
        list.add('9');
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        list.add('f');
    }

    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
//        if (!numberIsCorrect(number)) {
//            throw new NumberFormatException("Переданное число некорректно");
//        }
//
//        BigInteger numberInDecimalSystem = convertNumberToDecimalSystem(number);
//
//        String resultNumber = convertDecimalNumberToGivenNumberSystem(numberInDecimalSystem, expectedNumberSystem.getNumberSystemIntValue());
//
//        return new Number(expectedNumberSystem, resultNumber);
        BigInteger bi = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
        String ans = bi.toString(expectedNumberSystem.getNumberSystemIntValue());
        return new Number(expectedNumberSystem, ans);
    }

    private static boolean numberIsCorrect(Number number) {
        for (int i = 0; i < number.getDigit().length(); i++) {
            char tempChar = number.getDigit().charAt(i);
            if (!list.contains(tempChar) || list.indexOf(tempChar) >= number.getNumberSystem().getNumberSystemIntValue()) {
                return false;
            }
        }
        return true;
    }

    private static BigInteger convertNumberToDecimalSystem(Number number) {
        BigInteger result = BigInteger.ZERO;
        int numberSystem = number.getNumberSystem().getNumberSystemIntValue();
        int pow = number.getDigit().length() - 1;
        for (int i = 0; i < number.getDigit().length(); i++, pow--) {
            int tempNum = list.indexOf(number.getDigit().charAt(i));
            result  = result.add(BigInteger.valueOf((long) (tempNum * (Math.pow(numberSystem, pow)))));
        }
        return result;
    }

    private static String convertDecimalNumberToGivenNumberSystem(BigInteger numberInDecimalSystem, int numberSystemIntValue) {
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            BigInteger tempValue = numberInDecimalSystem.remainder(BigInteger.valueOf(numberSystemIntValue));
            stringBuilder.append(list.get(tempValue.intValue()));
            numberInDecimalSystem = numberInDecimalSystem.divide(BigInteger.valueOf(numberSystemIntValue));
            if (numberInDecimalSystem.compareTo(BigInteger.valueOf(numberSystemIntValue)) <= 0 ) {
                stringBuilder.append(list.get(numberInDecimalSystem.intValue()));
                break;
            }
        }

        return stringBuilder.reverse().toString();
    }
}
