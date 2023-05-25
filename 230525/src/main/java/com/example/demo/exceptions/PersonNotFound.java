package com.example.demo.exceptions;

public class PersonNotFound extends RuntimeException {
    public PersonNotFound(String name) {
        super(name);
    }
}
