package com.geekymon2.carmarketplace.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParameterException  extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidParameterException(String message) {
        super(message);
        log.error("{}: {}", this.getClass().getName(), message);
    }
}
