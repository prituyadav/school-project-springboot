package com.learning.school.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomExceptionHandler extends RuntimeException{

    String message;
    HttpStatus status;

    CustomExceptionHandler(){
    }

    public CustomExceptionHandler(String msg, HttpStatus status){
        super(msg);
        this.message = msg;
        this.status = status;
    }
}
