package com.learning.school.common;

import com.learning.school.dto.SuccessResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static ResponseEntity<SuccessResponseDto> successResponseHandler(Object data, HttpStatus status){
        SuccessResponseDto responseDto = new SuccessResponseDto();
        responseDto.setData(data);
        responseDto.setStatus(status);
        return new ResponseEntity<>(responseDto, status);
    }
}
