package org.urlshortener.repository;

import java.util.HashMap;
import java.util.Map;

public class UrlRepository {
    private Map<String, String> db;

    public UrlRepository() {
        this.db = new HashMap<>();
    }

    public String addUrl(String url) {
        return "";
    }

    public String readUrl(String shortUrl) {
        return "";
    }
}
