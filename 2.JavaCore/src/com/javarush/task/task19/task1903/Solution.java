package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
    }

    public static class IncomeDataAdapter implements Customer, Contact{

        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            for (Map.Entry<String, String> pair : countries.entrySet()) {
                if (pair.getKey().equals(data.getCountryCode())) return pair.getValue();
            }
            return data.getCountryCode();
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String code = Integer.toString(data.getCountryPhoneCode());
            String number = Integer.toString(data.getPhoneNumber());
            StringBuilder fixedNumber = new StringBuilder();
            if (number.length() < 10) {
                int count = 10-number.length();
                while (count>0) {
                    fixedNumber.append("0");
                    count--;
                }
            }
            fixedNumber.append(number);
            String tenDigitsNumber = fixedNumber.toString();
            return "+" + code + "(" + tenDigitsNumber.substring(0, 3) + ")" + tenDigitsNumber.substring(3, 6)
                    + "-" + tenDigitsNumber.substring(6,8) + "-" + tenDigitsNumber.substring(8);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}