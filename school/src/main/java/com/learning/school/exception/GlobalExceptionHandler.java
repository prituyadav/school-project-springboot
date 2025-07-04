package com.learning.school.exception;

import com.learning.school.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> internalServerException(HttpServerErrorException.InternalServerError ex){
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<ErrorResponseDto> notFoundException(HttpClientErrorException.NotFound ex){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
    }

    @ExceptionHandler(BadRequestExcep.class)
    public ResponseEntity<ErrorResponseDto> badRequest(BadRequestExcep ex){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
    }

    @ExceptionHandler(CustomExceptionHandler.class)
    public ResponseEntity<ErrorResponseDto> customException(CustomExceptionHandler ex){
        return errorResponseGenerator(ex);
    }

    private ResponseEntity<ErrorResponseDto> errorResponseGenerator(CustomExceptionHandler ex){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setStatus(ex.getStatus());
        //        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND); // alternate way to return
        return ResponseEntity.status(ex.getStatus()).body(errorResponseDto);
    }
}

