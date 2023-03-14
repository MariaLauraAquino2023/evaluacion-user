package com.evaluacion.util;

import java.util.regex.Pattern;

public final class UserUtil {
    public static Boolean validateEmail(String email){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }

    public static Boolean validatePassword(String password){
        String regexPattern = "^(?=.*[0-9]{2})(?=.*[a-z])(?=.*[A-Z]{1}).{8,20}$";
        return Pattern.compile(regexPattern)
                .matcher(password)
                .matches();
    }
}
