package com.geekymon2.carmarketplace.core.autoconfiguration.security.validator;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/auth/register",
            "/auth/login",
            "/eureka",
            "/api-docs"
    );

    public Predicate<HttpServletRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getRequestURI().contains(uri));
}