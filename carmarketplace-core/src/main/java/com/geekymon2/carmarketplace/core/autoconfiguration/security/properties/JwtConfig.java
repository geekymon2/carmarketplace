package com.geekymon2.carmarketplace.core.autoconfiguration.security.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtConfig {
    private Boolean jwtDisabled;
    private String jwtSecret;
    private long jwtValidity;
}
