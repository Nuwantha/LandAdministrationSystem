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
    public static boolean emailChecker(String email){
        String defaultModel="^[w-_\\.+]*[\\w-_@([\\w]+\\.)+[\\w]$";
        boolean status=email.matches(defaultModel);
        return status;
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
}
