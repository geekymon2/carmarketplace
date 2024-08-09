package com.geekymon2.carmarketplace.core.autoconfiguration.security.validator;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import java.util.function.Predicate;

@Slf4j
@Component
public class RouterValidator {
    private final RouterConfig config;

    public RouterValidator(RouterConfig config) {
        this.config = config;
    }

    @PostConstruct
    public void init() {
        log.info("Initializing Router validation configuration.");
    }

    public Predicate<HttpServletRequest> isSecured = this::isEndPointSecured;

    public boolean isEndPointSecured(HttpServletRequest request) {
        boolean isSecured = true;

        if (config.getOpenEndpoints() == null) {
            log.warn("Open API endpoints configuration not available in application properties.");
        } else {
            isSecured = config.getOpenEndpoints()
                    .stream()
                    .noneMatch(uri -> request.getRequestURI().contains(uri));
        }
        return isSecured;
    }
}