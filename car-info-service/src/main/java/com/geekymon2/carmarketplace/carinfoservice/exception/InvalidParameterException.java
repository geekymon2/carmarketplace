package com.geekymon2.carmarketplace.carinfoservice.exception;

public class InvalidParameterException  extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidParameterException(String message) {
        super(message);
    }
}
