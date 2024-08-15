package com.geekymon2.carmarketplace.core.autoconfiguration.apiexceptionhandler;

import com.geekymon2.carmarketplace.core.exception.InvalidParameterException;
import com.geekymon2.carmarketplace.core.exception.MissingHeaderInfoException;
import com.geekymon2.carmarketplace.core.exception.RecordNotFoundException;
import com.geekymon2.carmarketplace.core.models.ErrorResponseDto;
import jakarta.annotation.PostConstruct;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler
{
    private String BAD_REQUEST = "BAD_REQUEST";
    private String INVALID_PARAM = "INVALID_PARAMETER";
    private String NOT_FOUND = "NOT_FOUND";

    @PostConstruct
    public void init() {
        log.info("Initializing API Exception Handler Configuration");
    }

    @Generated
    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponseDto> handleRecordNotFoundException
                        (RecordNotFoundException ex, WebRequest request)
    {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponseDto error = new ErrorResponseDto(new Date(), HttpStatus.NOT_FOUND.value(), NOT_FOUND, details, ((ServletWebRequest)request).getRequest().getRequestURI());
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