package org.urlshortener.service;

import org.urlshortener.repository.UrlRepository;
import org.urlshortener.utils.ShortUrlGenerator;

public class UrlService {
    private UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String addUrl(String url) {
        String shortUrl = ShortUrlGenerator.generateUrl();
        urlRepository.addUrl(url, shortUrl);
        return shortUrl;
    }

    public String readUrl(String shortUrl) {
        return urlRepository.readUrl(shortUrl);
    }
}
