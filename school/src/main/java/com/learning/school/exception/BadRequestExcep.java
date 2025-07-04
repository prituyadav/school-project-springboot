package com.learning.school.exception;

public class BadRequestExcep extends RuntimeException{
    public BadRequestExcep(String msg){
        super(msg);
    }
}
