package com.project.my_collections.service.exceptions;

public class PasswordMisMatchException extends RuntimeException {

    public PasswordMisMatchException() {
    }

    public PasswordMisMatchException(String message) {
        super(message);
    }

}
