package com.example.demo.security;

import org.springframework.http.HttpStatus;

public abstract class AbstractException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String userMessage;

    protected AbstractException(HttpStatus httpStatus, String userMessage) {
        super();
        this.httpStatus = httpStatus;
        this.userMessage = userMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
