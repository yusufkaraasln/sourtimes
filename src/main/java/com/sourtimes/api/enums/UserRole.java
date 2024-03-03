package com.sourtimes.api.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
// this enum activate after authentication module will be implemented
public enum UserRole {

    ADMIN("ADMIN"),
    USER("USER");

    @Getter
    private final String value;



}

