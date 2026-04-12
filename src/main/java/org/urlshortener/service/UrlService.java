package org.urlshortener.service;

import org.urlshortener.repository.UrlRepository;

public class UrlService {
    private UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String addUrl(String url) {
        return urlRepository.addUrl(url);
    }

    public String readUrl(String shortUrl) {
        return urlRepository.readUrl(shortUrl);
    }
}
