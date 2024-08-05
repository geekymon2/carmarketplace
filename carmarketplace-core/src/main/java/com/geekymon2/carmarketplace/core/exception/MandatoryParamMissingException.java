package com.geekymon2.carmarketplace.core.exception;

public class MandatoryParamMissingException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MandatoryParamMissingException(String message) {
        super(message);
    }
}
