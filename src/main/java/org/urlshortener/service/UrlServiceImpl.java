package org.urlshortener.service;

import org.urlshortener.exception.UrlNotValidException;
import org.urlshortener.repository.UrlRepositoryImpl;
import org.urlshortener.utils.ShortUrlGenerator;
import org.urlshortener.utils.UrlValidator;

public class UrlServiceImpl implements  UrlService{
    private final UrlRepositoryImpl urlRepositoryImpl;

    public UrlServiceImpl(UrlRepositoryImpl urlRepositoryImpl) {
        this.urlRepositoryImpl = urlRepositoryImpl;
    }

    public String addUrl(String url) {
        boolean isValid = UrlValidator.isValid(url);
        if (!isValid) throw new UrlNotValidException("Url not valid!");

        String shortUrl = ShortUrlGenerator.generateUrl(url);
        urlRepositoryImpl.addUrl(url, shortUrl);
        return shortUrl;
    }

    public String readUrl(String shortUrl) {
        return urlRepositoryImpl.readUrl(shortUrl);
    }
}
