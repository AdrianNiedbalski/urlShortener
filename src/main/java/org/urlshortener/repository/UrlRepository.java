package org.urlshortener.repository;

import java.util.HashMap;
import java.util.Map;

public class UrlRepository {
    private Map<String, String> db;

    public UrlRepository() {
        this.db = new HashMap<>();
    }

    public void addUrl(String url, String shortUrl) {
        db.put(shortUrl, url);
    }

    public String readUrl(String shortUrl) {
        return db.get(shortUrl);
    }
}
