package org.urlshortener.utils;

import java.util.Random;

public class ShortUrlGenerator {
    public static String generateUrl() {
        String generatedUrl = "";
        String alfabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(alfabet.length());
            generatedUrl += alfabet.charAt(index);
        }

        return generatedUrl;
    }
}
