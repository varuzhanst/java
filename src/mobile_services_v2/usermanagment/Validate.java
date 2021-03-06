package mobile_services_v2.usermanagment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    /**
     * Full name validation
     * @param s
     * @return
     */
    public static boolean isFullNameValid(String s) {
        return Pattern.matches("[A-Z][a-z]+[ ][A-Z]{1}[a-z]+", s);
    }

    /**
     * email validation
     * @param email
     * @return
     */
    public static boolean isEmailValid(final String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * password validation
     * @param s
     * @return
     */
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

    /**
     * username validation
     * @param s
     * @return
     */
    public static boolean isUsernameValid(String s){
        if (s.length()<=10) return false;
        return UserService.getUserByUsername(s) == null;
    }
}
