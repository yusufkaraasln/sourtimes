package com.sourtimes.api.ex;

public class HeaderAlreadyExistException extends RuntimeException {

    public HeaderAlreadyExistException() {
        super("Header already exist.");
    }
}
