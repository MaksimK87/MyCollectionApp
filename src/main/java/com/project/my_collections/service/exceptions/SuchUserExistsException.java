package com.project.my_collections.service.exceptions;

public class SuchUserExistsException extends RuntimeException {

    public SuchUserExistsException() {
    }

    public SuchUserExistsException(String message) {
        super(message);
    }
}
