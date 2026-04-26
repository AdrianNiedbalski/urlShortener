package org.urlshortener;

import lombok.extern.slf4j.Slf4j;
import org.urlshortener.controller.UrlController;
import org.urlshortener.repository.UrlRepositoryImpl;
import org.urlshortener.service.UrlServiceImpl;

@Slf4j
public class UrlApp {
    public static void main(String[] args) {
        UrlRepositoryImpl urlRepositoryImpl = new UrlRepositoryImpl();
        UrlServiceImpl urlServiceImpl = new UrlServiceImpl(urlRepositoryImpl);
        UrlController urlController = new UrlController(urlServiceImpl);
        urlController.start();
    }
}