package com.example.market.exception;

import com.example.market.model.response.APIErrorDTO;
import com.example.market.model.response.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class})
    public ResponseData<?> valid(Exception ex, WebRequest request) {
        APIErrorDTO errorDTO = APIErrorDTO.builder()
                .developerMessage(ex.getStackTrace().toString())
                .message(ex.getMessage())
                .path(request.getContextPath())
                .build();
        return new ResponseData<>(errorDTO, HttpStatus.CONFLICT.value());
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseData<?> valid(NotFoundException ex, WebRequest request) {
        APIErrorDTO errorDTO = APIErrorDTO.builder()
                .developerMessage(ex.getStackTrace().toString())
                .message(ex.getMessage())
                .path(request.getContextPath())
                .build();
        return new ResponseData<>(errorDTO, HttpStatus.NOT_FOUND.value());
    }

}
