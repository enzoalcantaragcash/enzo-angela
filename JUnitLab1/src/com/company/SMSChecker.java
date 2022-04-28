package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.HashMap;

public class SMSChecker {

    public static boolean checkRegisterKeyword (HashMap<String, String> smsMap) {

        boolean result = false;
        String message = smsMap.get("Message");

        if (message.trim().equalsIgnoreCase("register")) {
            result =true;
        }
        return result;
    }

    public static boolean checkUserInfo(HashMap<String, String> smsMap) {

        boolean result = false;
        String message = smsMap.get("Message");

        message = message.trim();

        if(message.split(",").length !=3) {
            return result;
        }

        String[] messageSplit = message.split(",");
        String name = messageSplit[0].trim();
        String birthday = messageSplit[1].trim();
        String location = messageSplit[2].trim();

        //NAME CHECKER
        String[] nameSplit = name.split(" ");

        //name length checker
        if (nameSplit.length == 1) {
            return result;
        }

        //check if format is correct (if first letter is capitalized per name)
        boolean invalidNameFormat = false;
        for (int i =0; i< nameSplit.length; i++) {
            if(!Character.isUpperCase(nameSplit[i].charAt(0))){
                invalidNameFormat = true;
            }
            for (int j=1; j<nameSplit[i].length();j++) {
                if(!Character.isLowerCase(nameSplit[i].charAt(j))){
                    invalidNameFormat = true;
                }
            }
        }
        if(invalidNameFormat) {
            return result;
        }

        //BIRTHDAY CHECKER
        String[] birthdaySplit = birthday.split("-");



        if (birthdaySplit.length < 3) return result; //ok

        LocalDate formattedBirthdate = null;
        try {
            formattedBirthdate = LocalDate.parse(birthday);
            //By default, LocalDate.parse() method parsed a date using ISO_LOCAL_DATE pattern (yyyy-MM-dd).
        } catch (DateTimeParseException e) {
            return result;
        } //ok

        if (formattedBirthdate.compareTo(LocalDate.now()) >= 0) return result;



        if (location.length() == 1) return result;
        //location checker
        String[] locationSplit = location.split(" ");
        boolean invalidLocationFormat = false;
        boolean stringHasDigit = false;
        boolean stringHasLetter = false;
        for (String s : locationSplit) {
            for (int j = 1; j < s.length(); j++) {
                if (!Character.isLetter(s.charAt(j))) {
                    stringHasLetter = true;
                }
                if (!Character.isDigit(s.charAt(j))) {
                    stringHasDigit = true;
                }
                if (stringHasDigit && stringHasLetter) {
                    invalidLocationFormat = true;
                    break;
                }
                stringHasDigit = false;
                stringHasLetter = false;
            }
            if (invalidLocationFormat) {
                break;
            }
        }
        if (invalidLocationFormat) {
            return result;
        }

        return true;
    }
}
