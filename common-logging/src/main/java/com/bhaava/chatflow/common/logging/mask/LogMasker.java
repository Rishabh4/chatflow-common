package com.bhaava.chatflow.common.logging.mask;

public final class LogMasker {

    private LogMasker() {}

    public static String maskEmail(String email) {
        if (email == null || !email.contains("@")) return email;
        return email.charAt(0) + "****@" + email.split("@")[1];
    }

    public static String maskPhone(String phone) {
        if (phone == null || phone.length() < 4) return phone;
        return "****" + phone.substring(phone.length() - 4);
    }
}
