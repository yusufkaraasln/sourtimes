package com.sourtimes.api.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private boolean success;
    private String message;
    private T data;


    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}