package com.sns.dongore.user;

public class AppUserUtility {

    // email validation
    public static boolean isValidEmail(String email) {
        int atIdx = email.indexOf("@");
        if (atIdx == -1) return false;

        int dotIdx = email.substring(atIdx).indexOf(".");
        if (dotIdx == -1) return false;

        return true;
    }

    // password validation
    public static boolean isValidPassword(String password) {
        return password.length() > 6;
    }

    // nickname validation은 Repo에서
}
