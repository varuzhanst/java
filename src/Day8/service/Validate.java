package Day8.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean isFullNameValid(String s) {
        return Pattern.matches("[A-Z][a-z]+[ ][A-Z]{1}[a-z]+", s);
    }


    public static boolean isEmailValid(final String email) {
        Pattern pattern = Pattern.compile("^(.+)@(\\S+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isPasswordValid(String s) {

        int countUppercase = 0, countNumbers = 0;
        if (s.length() < 9) return false;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current >= '0' && current <= '9') countNumbers++;
            else if (current >= 'A' && current <= 'Z') countUppercase++;
        }
        return countUppercase > 2 && countNumbers > 3;

    }

    public static boolean isUsernameValid(String s){
        if (s.length()<=10) return false;
        return UserService.getUserByUsername(s) == null;
    }
}
