package com.delidrop.springboot.helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Helper {
    // Returns an encrypted String with MD5
    public static String encryptString(String input) throws NoSuchAlgorithmException {

        //MessageDigest works with MD2, MD5, SHA-1, SHA-224, SHA-256, SHA-384, and SHA-512
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] messageDigest = md.digest(input.getBytes());

        BigInteger bigInt = new BigInteger(1, messageDigest);

        return bigInt.toString(16);
    }

    // Returns the current local date as a string
    public static Date getCurrentTime() {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        LocalDate date = LocalDate.now();

//        return dtf.format(date);

        Date d = new Date();
        return d;
    }


    /**
     * Formats a given string:
     *         Removes trailing and leading spaces,
     *         Removes any special characters,
     *         Capitalizes first letter
     * @param value the string to be formatted
     * @return a formatted string
     */
    public static String formatString(String value) {

        String tempString = value.trim();
        tempString = tempString.replaceAll("\\s","");

        String result = "";

        // Removes special characters and removes trailing and leading space
        // checks for the ASCII value of the character to be a valid alphabetical letter
        for(int i=0; i<tempString.length(); i++) {
            // comparing alphabets with their corresponding ASCII value
            if(tempString.charAt(i)>64 && tempString.charAt(i) <= 90
                || tempString.charAt(i)>96 && tempString.charAt(i) <=122) {
                result = result + tempString.charAt(i);
            }
        }
        // returns the result string without the special characters if any, and capitalizes
        // first letter of string.
        return result.substring(0,1).toUpperCase() + result.substring(1).toLowerCase();
    }

    public static boolean verifyPhoneNumber(Long phone) {
        String phoneNumber = Long.toString(phone);

        if(phoneNumber.length() < 6) {
            return false;
        }

        int reps = 0;
        int currNumber = phoneNumber.charAt(0);
        for(int i = 1; i < phoneNumber.length(); i++) {
            if(phoneNumber.charAt(i) == currNumber) {
                reps++;
                if(reps > 2) return false;
            }
            else {
                reps = 0;
            }
            currNumber = phoneNumber.charAt(i);
        }

        return true;
    }
}
