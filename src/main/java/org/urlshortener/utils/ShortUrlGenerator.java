package org.urlshortener.utils;

public class ShortUrlGenerator {
    public static String generateUrl(String url) {
        return String.valueOf(url.hashCode());
    }
}
