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
        log.info("---CHOSE OPTION---");
        log.info("1. Add url");
        log.info("2. Read URL");
        log.info("3. Exit");
    }

    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    log.info("Incorrect choice!");
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
