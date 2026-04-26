package org.urlshortener.exception;

public class UrlNotValidException extends RuntimeException {
    public UrlNotValidException(String message) {
        super(message);
    }
}
