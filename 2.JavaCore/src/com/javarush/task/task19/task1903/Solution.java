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
//        System.out.println(getPhoneNumber());
    }

//    public static String getPhoneNumber() {
////            int countyCode = data.getCountryPhoneCode();
//        int countyCode = 38;
////            String phoneNumberWithCodeString = "" + data.getPhoneNumber();
//        String phoneNumberWithCodeString = "" + Integer.valueOf(501234567);
//        System.out.println(phoneNumberWithCodeString);
//        while (phoneNumberWithCodeString.length() < 10) phoneNumberWithCodeString = "0" + phoneNumberWithCodeString;
//        String code = phoneNumberWithCodeString.substring(0, phoneNumberWithCodeString.length() - 7);
//        String phoneNumber = phoneNumberWithCodeString.substring(phoneNumberWithCodeString.length() - 7);
//        String part1 = phoneNumber.substring(0, 3);
//        String part2 = phoneNumber.substring(3, 5);
//        String part3 = phoneNumber.substring(5, 7);
//        return "+" + countyCode + "(" + code + ")" + part1 + "-" + part2 + "-" + part3;
//
//    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            int countyCode = data.getCountryPhoneCode();
            String phoneNumberWithCodeString = "" + data.getPhoneNumber();
            System.out.println(phoneNumberWithCodeString);
            while (phoneNumberWithCodeString.length() < 10) phoneNumberWithCodeString = "0" + phoneNumberWithCodeString;
            String code = phoneNumberWithCodeString.substring(0, phoneNumberWithCodeString.length() - 7);
            String phoneNumber = phoneNumberWithCodeString.substring(phoneNumberWithCodeString.length() - 7);
            String part1 = phoneNumber.substring(0, 3);
            String part2 = phoneNumber.substring(3, 5);
            String part3 = phoneNumber.substring(5, 7);
            return "+" + countyCode + "(" + code + ")" + part1 + "-" + part2 + "-" + part3;

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