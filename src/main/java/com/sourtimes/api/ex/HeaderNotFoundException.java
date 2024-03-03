package com.sourtimes.api.ex;

public class HeaderNotFoundException extends RuntimeException {

    public HeaderNotFoundException() {
        super("Header not found.");
    }

}
