package org.urlshortener.service;

public interface UrlService {
    String addUrl(String url);
    String readUrl(String shortUrl);
}
