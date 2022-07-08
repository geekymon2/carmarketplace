package com.geekymon2.carmarketplace.core.security.autoconfiguration.jwt;

import com.geekymon2.carmarketplace.core.exception.jwt.JwtTokenIncorrectStructureException;
import com.geekymon2.carmarketplace.core.exception.jwt.JwtTokenMalformedException;
import com.geekymon2.carmarketplace.core.exception.jwt.JwtTokenMissingException;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.properties.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.stereotype.Component;
import java.sql.Date;

@Component
public class JwtTokenUtil {
    private final JwtConfig config;

    public JwtTokenUtil(JwtConfig config) {
        this.config = config;
    }

    public String generateToken(String id) {
        Claims claims = Jwts.claims().setSubject(id);
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + config.getJwtValidity() * 1000 * 60;
        Date exp = new Date(expMillis);
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(exp)
                .signWith(SignatureAlgorithm.HS512, config.getJwtSecret()).compact();
    }

    public void validateToken(final String header) throws JwtTokenMalformedException, JwtTokenMissingException {
        try {
            String[] parts = header.split(" ");
            if (parts.length != 2 || !"Bearer".equals(parts[0])) {
                throw new JwtTokenIncorrectStructureException("Incorrect Authentication Structure");
            }

            Jwts.parser().setSigningKey(config.getJwtSecret()).parseClaimsJws(parts[1]);
        } catch (MalformedJwtException ex) {
            throw new JwtTokenMalformedException("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throw new JwtTokenMalformedException("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new JwtTokenMalformedException("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throw new JwtTokenMissingException("JWT claims string is empty.");
        }
    }
}
