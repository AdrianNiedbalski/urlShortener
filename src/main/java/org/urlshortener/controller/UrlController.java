package org.urlshortener.controller;

import lombok.extern.slf4j.Slf4j;
import org.urlshortener.dto.Command;
import org.urlshortener.dto.InputData;
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

    public void start() {
        boolean running = true;
        String url = "";
        String shortUrl = "";

        while (running) {
            String userInput = scanner.nextLine();
            InputData inputData = menuHandler(userInput);

            switch (inputData.getCommand()) {
                case Command.ADD:
                    addUrlHandler(inputData.getUrl());
                    break;
                case Command.READ:
                    readUrlHandler(inputData.getUrl());
                    break;
                case Command.EXIT:
                    running = false;
                    break;
                default:
                    log.info("Incorrect choice!");
                    break;
            }
        }
    }

    private void addUrlHandler(String url) {
        String shortUrl = "";

        try {
            shortUrl = urlServiceImpl.addUrl(url);
            log.info(shortUrl);
        } catch (UrlNotValidException e) {
            log.info("Wrong url, try again!");
        }
    }

    private void readUrlHandler(String shortUrl) {
        String url = "";

        try {
            url = urlServiceImpl.readUrl(shortUrl);
            log.info(url);
        } catch (UrlNotValidException e) {
            log.info("Wrong key!");
        }
    }

    private InputData menuHandler(String input) {
        String[] inputArray = input.split(" ");
        InputData inputData = new InputData(Command.EXIT, "");

        if (inputArray.length != 2) {
            log.info("Wrong input!");
        } else {
            switch (inputArray[0]) {
                case "/ADD":
                    inputData.setCommand(Command.ADD);
                    inputData.setUrl(inputArray[1]);
                    break;
                case "/READ":
                    inputData.setCommand(Command.READ);
                    inputData.setUrl(inputArray[1]);
                    break;
                case "/EXIT":
                    inputData.setCommand(Command.EXIT);
                    break;
                default:
                    log.info("Wrong command!");
                    break;
            }
        }
        return inputData;
    }
}
