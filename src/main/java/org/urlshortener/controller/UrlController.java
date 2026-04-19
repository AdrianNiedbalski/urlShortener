package org.urlshortener.controller;

import lombok.extern.slf4j.Slf4j;
import org.urlshortener.exception.UrlNotValidException;
import org.urlshortener.service.UrlServiceImpl;

import java.util.Scanner;

@Slf4j
public class UrlController {
    private final UrlServiceImpl urlServiceImpl;
    private final Scanner scanner;

    public UrlController(UrlServiceImpl urlServiceImpl) {
        this.urlServiceImpl = urlServiceImpl;
        this.scanner = new Scanner(System.in);
    }

    private void printMenu() {
        String menu = """
                ---CHOOSE OPTION---
                1. Add url
                2. Read URL
                3. Exit
                """;
        log.info(menu);
    }

    public void start() {
        boolean running = true;
        String url = "";
        String shortUrl = "";

        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                //Handle Url
                case "1":
                    addUrlHandler(url, shortUrl);
                    break;
                case "2":
                    log.info("Write short url:\n");
                    shortUrl = scanner.nextLine();
                    url = urlServiceImpl.readUrl(shortUrl);
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

    /*public String addUrl(String url) {
        return urlServiceImpl.addUrl(url);
    }

    public String readUrl(String shortUrl) {
        return urlServiceImpl.readUrl(shortUrl);
    }*/

    private void addUrlHandler(String url, String shortUrl) {
        while (true) {
            log.info("Write url:\n");
            url = scanner.nextLine();
            try {
                shortUrl = urlServiceImpl.addUrl(url);
                log.info(shortUrl);
                break;
            } catch (UrlNotValidException e) {
                log.info("Wrong url, try again!");
            }
        }
    }
}
