package org.urlshortener.controller;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.urlshortener.service.UrlService;

import java.util.Scanner;

@Slf4j
public class UrlController {
    private UrlService urlService;
    private Scanner scanner;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
        this.scanner = new Scanner(System.in);
    }

    private void printMenu() {
        log.info("---CHOSE OPTION---\n 1. Add url\n 2. Read URL\n 3. Exit");
    }

    public void start() {
        boolean running = true;
        String url;
        String shortUrl;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                //Handle Url
                case "1":
                    log.info("Write url:\n");
                    url = scanner.nextLine();
                    shortUrl = urlService.addUrl(url);
                    log.info(shortUrl);
                    break;
                case "2":
                    log.info("Write short url:\n");
                    shortUrl = scanner.nextLine();
                    url = urlService.readUrl(shortUrl);
                    log.info(url);
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    log.info("Incorrect choice!");
                    break;
            }
        }
    }

    public String addUrl(String url) {
        return urlService.addUrl(url);
    }

    public String readUrl(String shortUrl) {
        return urlService.readUrl(shortUrl);
    }

}
