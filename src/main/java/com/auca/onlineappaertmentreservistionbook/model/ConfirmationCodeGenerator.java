package com.auca.onlineappaertmentreservistionbook.model;

import java.util.Random;

public class ConfirmationCodeGenerator {
    public static String generateConfirmationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }
}
