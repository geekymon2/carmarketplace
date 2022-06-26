package com.geekymon2.carmarketplace.core.security.jwt;

import java.util.Date;

import com.geekymon2.carmarketplace.core.exception.JwtTokenIncorrectStructureException;
import com.geekymon2.carmarketplace.core.exception.JwtTokenMalformedException;
import com.geekymon2.carmarketplace.core.exception.JwtTokenMissingException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {
	private final String secret = "secret";

	public String generateToken(String id) {
		int validity = 20;

		Claims claims = Jwts.claims().setSubject(id);
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + validity * 1000 * 60;
		Date exp = new Date(expMillis);
		return Jwts.builder().
				setClaims(claims).
				setIssuedAt(new Date(nowMillis)).
				setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, secret).
				compact();
	}

	public void validateToken(final String header) throws JwtTokenMalformedException, JwtTokenMissingException {
		try {
			String[] parts = header.split(" ");
			if (parts.length != 2 || !"Bearer".equals(parts[0])) {
				throw new JwtTokenIncorrectStructureException("Incorrect Authentication Structure");
			}

			Jwts.parser().setSigningKey(secret).parseClaimsJws(parts[1]);
		} catch (SignatureException ex) {
			throw new JwtTokenMalformedException("Invalid JWT signature");
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
