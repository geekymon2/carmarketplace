package com.geekymon2.carmarketplace.core.autoconfiguration.security.jwt;

import com.geekymon2.carmarketplace.core.autoconfiguration.security.properties.JwtConfig;
import com.geekymon2.carmarketplace.core.exception.jwt.JwtTokenIncorrectStructureException;
import com.geekymon2.carmarketplace.core.exception.jwt.JwtTokenValidationException;
import io.jsonwebtoken.ClaimsBuilder;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.sql.Date;


@Component
@Slf4j
public class JwtTokenUtil {
    private final JwtConfig config;

    public JwtTokenUtil(JwtConfig config) {
        this.config = config;
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = config.getJwtSecret().getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String id) {
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + config.getJwtValidity() * 1000 * 60;
        Date exp = new Date(expMillis);

        ClaimsBuilder claimsBuilder = Jwts.claims().subject(id);

        return Jwts.builder()
                .claims(claimsBuilder.build())
                .subject(id)
                .issuedAt(new Date(nowMillis))
                .expiration(exp)
                .signWith(getSigningKey())
                .compact();
    }

    public void validateToken(final String header) throws JwtTokenValidationException {
        try {
            String[] parts = header.split(" ");
            if (parts.length != 2 || !"Bearer".equals(parts[0])) {
                throw new JwtTokenIncorrectStructureException("Incorrect Authentication Structure");
            }

            Jwts.parser().verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(parts[1])
                    .getPayload();

        } catch (MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            log.error("Failed to validate JWT token", e);
            throw new JwtTokenValidationException("Failed to validate JWT token");
        }
    }
}
