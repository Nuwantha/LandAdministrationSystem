
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.common_classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gimhani
 */
public class PatternChecker {
    /*This class contains all the methods needed in data verifications.*/
    public static String checkNIC(String nicText) {
        int result = 0;
        if (nicText.length() == 10) {
            Pattern pattern = Pattern.compile("[0-9]{9}[VX]");
            Matcher matcher = pattern.matcher(nicText);
            if (matcher.find()) {
            } else {
                nicText = nicText.substring(0, nicText.length() - 1);
            }
        } else if (nicText.length() < 10) {
            Pattern pattern = Pattern.compile("[0-9]{" + nicText.length() + "}");
            Matcher matcher = pattern.matcher(nicText);
            if (matcher.find()) {
            } else {
                nicText = nicText.substring(0, nicText.length() - 1);
            }

        } else if (nicText.length() > 10) {
            nicText = nicText.substring(0, nicText.length() - 1);
        }
        return nicText;
    }
public static boolean checkNICdirect(String nicText) {
        
        if (nicText.length() == 10) {
            Pattern pattern = Pattern.compile("[0-9]{9}[VX]");
            Matcher matcher = pattern.matcher(nicText);
            if (matcher.find()) {
                return true;
            } else {
                return false;
            }
        } else if (nicText.length() != 10) {
           return false;
        }
        else{
            return false;
        }
    }

    public static String checkTelNum(String telText) {
        int result;
        if (telText.length() == 1) {
            Character c = telText.charAt(0);
            Pattern pattern = Pattern.compile("0");
            Matcher matcher = pattern.matcher(c.toString());
            if (!matcher.find()) {
                telText = telText.substring(0, telText.length() - 1);
            }
        } else if (telText.length() == 2 | telText.length() == 3) {
            Pattern pattern = Pattern.compile("[0][1-9]{" + (telText.length() - 1) + "}");
            Matcher matcher = pattern.matcher(telText);
            if (!matcher.find()) {
                telText = telText.substring(0, telText.length() - 1);
            }
        } else if (telText.length() > 3 & telText.length() <= 10) {
            Pattern pattern = Pattern.compile("[0][1-9]{2}[0-9]{" + (telText.length() - 3) + "}");
            Matcher matcher = pattern.matcher(telText);
            if (!matcher.find()) {
                telText = telText.substring(0, telText.length() - 1);
            }
        } else if (telText.length() > 10) {
            telText = telText.substring(0, telText.length() - 1);
        }
        return telText;
    }
     public static boolean checkTelNumdirect(String telText) {
        if (telText.length()== 10) {
            Pattern pattern2 = Pattern.compile("[0][1-9]{2}[0-9]{" + (telText.length() - 3) + "}");
            Matcher matcher2 = pattern2.matcher(telText);
            if (!matcher2.find()) {
                return false;
            }
            else{
                return true;
            }
        }
       
        else{
            return false;
            }
        
     }
    public static boolean birthdayChecker(String birthday){
        SimpleDateFormat sdf=new SimpleDateFormat("MM/d/yyyy");
        Date testdate=null;
        try{
            testdate=sdf.parse(birthday);
                   }
        catch(ParseException e){
            System.out.println("Invalid Date Format");
            return false;
        }
        if(!sdf.format(testdate).equals(birthday)){
            System.out.println("Invalid Date Format");
            return false;
        }
        return true;
    }
        public static String checkDecimal(String text) {
        int result;
        for (int i = 1; i < text.length() + 1; i++) {
            Character c = text.charAt(i - 1);
            Pattern pattern = Pattern.compile("[0-9.]");//[a-z A-Z]
            Matcher matcher = pattern.matcher(c.toString());
            if (matcher.find()) {
                result = 1;
            } else {
                result = 0;
            }
            if (result == 0) {
                text = text.substring(0, i - 1);
            }
        }
        return text;

    }
        public static boolean checkDecimaldirect(String text) {
        
            Pattern pattern = Pattern.compile("[0-9.]");//[a-z A-Z]
            Matcher matcher = pattern.matcher(text);
        return matcher.find();               
    }
        public static boolean checkIntegerdirect(String text) {
        
            Pattern pattern = Pattern.compile("[0-9]");//[a-z A-Z]
            Matcher matcher = pattern.matcher(text);
        return matcher.find();               
    }
         public static boolean checkStringdirect(String text) {
        
            Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$");//[a-z A-Z]
            Matcher matcher = pattern.matcher(text);
        return matcher.find();               
    }
        public static String checkstring(String text) {
        int result;
        for (int i = 1; i < text.length() + 1; i++) {
            Character c = text.charAt(i - 1);
            Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$");//
            Matcher matcher = pattern.matcher(c.toString());
            if (matcher.find()) {
                result = 1;
            } else {
                result = 0;
            }
            if (result == 0) {
                text = text.substring(0, i - 1);
            }
        }
        return text;

    }
    public static String checkPrice(String text) {
        int result = 0;
        for (int i = 1; i < text.length() + 1; i++) {
            Character c = text.charAt(i - 1);
            Pattern pattern = Pattern.compile("[.]");
            Matcher matcher = pattern.matcher(c.toString());
            if (matcher.find()) {
                result = 1;
            } else {
                result = 0;
            }    
        }
         if (result == 0) {
                text = text.concat(".00");
            }
        return text;
    }

    public static String checkInteger(String text) {
        int result;
        for (int i = 1; i < text.length() + 1; i++) {
            Character c = text.charAt(i - 1);
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(c.toString());
            if (matcher.find()) {
                result = 1;
            } else {
                result = 0;
            }
            if (result == 0) {
                text = text.substring(0, i - 1);

            }
        }
        return text;

    }
    public static String checkDate(String text) {
        int result;
        for (int i = 1; i < text.length() + 1; i++) {
            Character c = text.charAt(i - 1);
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(c.toString());
            if (matcher.find()) {
                result = 1;
            } else {
                result = 0;
            }
            if (result == 0) {
                text = text.substring(0, i - 1);

            }
        }
        return text;

    }
}
