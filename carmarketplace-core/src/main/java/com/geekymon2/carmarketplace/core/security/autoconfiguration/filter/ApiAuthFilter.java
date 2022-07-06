package com.geekymon2.carmarketplace.core.security.autoconfiguration.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekymon2.carmarketplace.core.exception.jwt.JwtTokenIncorrectStructureException;
import com.geekymon2.carmarketplace.core.exception.jwt.JwtTokenMalformedException;
import com.geekymon2.carmarketplace.core.exception.jwt.JwtTokenMissingException;
import com.geekymon2.carmarketplace.core.models.ErrorResponseDto;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.jwt.JwtTokenUtil;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.validator.RouterValidator;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.properties.ApiConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
public class ApiAuthFilter extends OncePerRequestFilter {
    private final JwtTokenUtil tokenUtil;
    private final ApiConfig config;
    private final RouterValidator validator;
    public ApiAuthFilter(JwtTokenUtil tokenUtil, ApiConfig config, RouterValidator validator) {
        this.tokenUtil = tokenUtil;
        this.config = config;
        this.validator = validator;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        boolean notFiltered;
        notFiltered = !validator.isSecured.test(request);

        if (notFiltered) {
            log.warn("JWT authentication request filtering bypassed for open endpoint: {}", request.getRequestURI());
        }

        return notFiltered;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (!config.getJwtConfig().getJwtDisabled()) {
            String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            try {
                if (authHeader == null) {
                    throw new JwtTokenMissingException("Missing Authorisation Header");
                }

                tokenUtil.validateToken(authHeader);

            } catch (JwtTokenMalformedException |
                     JwtTokenMissingException |
                     JwtTokenIncorrectStructureException e) {
                log.error("Error Validating Authentication Header in API Authentication Filter", e);
                ArrayList<String> details = new ArrayList<>();
                details.add(e.getMessage());
                ErrorResponseDto error = new ErrorResponseDto(new Date(), HttpStatus.UNAUTHORIZED.value(),
                        "UNAUTHORIZED", details, request.getRequestURI());
                response.setContentType("application/json");
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write(convertObjectToJson(error));
                return;
            }
        }
        else {
            log.warn("Unauthenticated request: {}", request.getRequestURI());
            log.warn("JWT authentication is disabled. This is not intended for Production Environment.");
        }

        filterChain.doFilter(request, response);
    }

    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
