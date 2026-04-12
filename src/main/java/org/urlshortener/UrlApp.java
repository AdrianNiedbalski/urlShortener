package org.urlshortener;

import lombok.extern.slf4j.Slf4j;
import org.urlshortener.controller.UrlController;
import org.urlshortener.repository.UrlRepository;
import org.urlshortener.service.UrlService;

@Slf4j
public class UrlApp {
    public static void main(String[] args) {
        UrlRepository urlRepository = new UrlRepository();
        UrlService urlService = new UrlService(urlRepository);
        UrlController urlController = new UrlController(urlService);
        urlController.start();
    }
}