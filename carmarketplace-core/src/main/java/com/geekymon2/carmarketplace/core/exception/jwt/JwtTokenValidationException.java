package com.geekymon2.carmarketplace.core.exception.jwt;

import javax.naming.AuthenticationException;

public class JwtTokenValidationException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public JwtTokenValidationException(String msg) {
        super(msg);
    }

}
