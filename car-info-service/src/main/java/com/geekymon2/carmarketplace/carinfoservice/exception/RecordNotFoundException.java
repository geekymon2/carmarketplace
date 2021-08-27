package com.geekymon2.carmarketplace.carinfoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
@Slf4j
public class RecordNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
 
    public RecordNotFoundException(String message) {
        super(message);
        log.error(this.getClass().getName() + ": " + message);
    }
}