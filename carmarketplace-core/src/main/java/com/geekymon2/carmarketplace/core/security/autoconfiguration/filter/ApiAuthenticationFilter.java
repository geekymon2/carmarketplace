package com.geekymon2.carmarketplace.core.security.autoconfiguration.filter;

import com.geekymon2.carmarketplace.core.exception.JwtTokenMalformedException;
import com.geekymon2.carmarketplace.core.exception.JwtTokenMissingException;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.properties.ApiConfig;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.validator.RouterValidator;
import com.geekymon2.carmarketplace.core.security.jwt.JwtTokenUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class ApiAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenUtil tokenUtil;
    private final ApiConfig config;
    private final RouterValidator validator;

    public ApiAuthenticationFilter(JwtTokenUtil tokenUtil, ApiConfig config, RouterValidator validator) {
        this.tokenUtil = tokenUtil;
        this.config = config;
        this.validator = validator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (validator.isSecured.test(request) && !config.getSecurity().getJwtDisabled()) {
            String authHeader = Objects.requireNonNull(request.getHeader(HttpHeaders.AUTHORIZATION));
            try {
                tokenUtil.validateToken(authHeader);
            } catch (JwtTokenMalformedException | JwtTokenMissingException e) {
                throw new RuntimeException(e);
            }
        }

        filterChain.doFilter(request, response);
    }
}