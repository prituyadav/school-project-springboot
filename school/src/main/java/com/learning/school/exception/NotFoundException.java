package com.learning.school.exception;

public class NotFoundException extends RuntimeException{
    NotFoundException(String msg){
        super(msg);
    }
}
