package com.sourtimes.api.ex;


import com.sourtimes.api.util.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HeaderNotFoundException.class)
    public ResponseEntity handleHeaderNotFoundException(HeaderNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Result(false, e.getMessage()));
    }

    @ExceptionHandler(HeaderAlreadyExistException.class)
    public ResponseEntity handleHeaderAlreadyExistException(HeaderAlreadyExistException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new Result(false, e.getMessage()));
    }

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity handleEntryNotFoundException(EntryNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Result(false, e.getMessage()));
    }


}