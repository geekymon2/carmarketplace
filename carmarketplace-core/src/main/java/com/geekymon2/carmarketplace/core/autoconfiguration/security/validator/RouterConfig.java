package com.geekymon2.carmarketplace.core.autoconfiguration.security.validator;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Getter
@Setter
@Configuration
@Primary
@ConfigurationProperties(prefix = "app-config.router-config")
public class RouterConfig {
    private List<String> openEndpoints;
}