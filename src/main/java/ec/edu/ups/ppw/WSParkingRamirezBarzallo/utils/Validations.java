package ec.edu.ups.ppw.WSParkingRamirezBarzallo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    public static boolean validatePassword(String password) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
