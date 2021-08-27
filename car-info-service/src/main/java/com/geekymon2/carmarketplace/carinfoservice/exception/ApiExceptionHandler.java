package com.geekymon2.carmarketplace.carinfoservice.exception;

import com.geekymon2.carmarketplace.carinfoservice.models.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.Generated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler 
{
    private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    private String BAD_REQUEST = "BAD_REQUEST";
    private String INVALID_PARAM = "INVALID_PARAMETER";

    @Generated
    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponseDto> handleRecordNotFoundException
                        (RecordNotFoundException ex, WebRequest request) 
    {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponseDto error = new ErrorResponseDto(new Date(), HttpStatus.NOT_FOUND.value(), INCORRECT_REQUEST, details, ((ServletWebRequest)request).getRequest().getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @Generated     
    @ExceptionHandler(MissingHeaderInfoException.class)
    public final ResponseEntity<ErrorResponseDto> handleInvalidTraceIdException
                        (MissingHeaderInfoException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponseDto error = new ErrorResponseDto(new Date(), HttpStatus.BAD_REQUEST.value(), BAD_REQUEST, details, ((ServletWebRequest)request).getRequest().getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Generated
    @ExceptionHandler(InvalidParameterException.class)
    public final ResponseEntity<ErrorResponseDto> handleInvalidParameterException
            (InvalidParameterException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponseDto error = new ErrorResponseDto(new Date(), HttpStatus.BAD_REQUEST.value(), INVALID_PARAM, details, ((ServletWebRequest)request).getRequest().getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}