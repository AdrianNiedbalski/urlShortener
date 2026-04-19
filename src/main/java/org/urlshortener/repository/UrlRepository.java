package org.urlshortener.repository;

public interface UrlRepository {
    void addUrl(String url, String shortUrl);
    String readUrl(String shortUrl);
}
