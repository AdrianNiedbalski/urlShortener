package org.urlshortener.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class UrlValidator {
    public static boolean isValid(String url) {
        try {
            URI uri = new URI(url);
            if (uri.getScheme() == null || uri.getHost() == null) return false;
            uri.toURL();
            return true;
        } catch (URISyntaxException | MalformedURLException | IllegalArgumentException exception) {
            return false;
        }
    }
}
