package com.arnoldatse.look4dev.app.security.jwtutils;

import com.arnoldatse.look4dev.core.entities.user.dtos.UserTokenInfosDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Component
public class TokenManager extends com.arnoldatse.look4dev.core.auth.TokenManager implements Serializable {
    @Serial
    private static final long serialVersionUID = 7008375124389347049L;

    @Value("${app.security.jwt.secret}")
    private String jwtSecret;

    @Value("${app.name}")
    private String appName;

    @Override
    public String generateToken(UserTokenInfosDto user) {
        return Jwts.builder()
                .setSubject("JWT Token")
                .setIssuer(appName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
                .claim("email", user.email())
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    @Override
    public boolean validateToken(String token, String userEmail) {
        Claims claims = getClaimsFromToken(token);
        String email = getEmailFromClaims(claims);
        boolean isTokenExpired = claims.getExpiration().before(new Date());
        return (email.equals(userEmail) && !isTokenExpired);
    }

    @Override
    public String getTokenEmail(String token) {
        Claims claims = getClaimsFromToken(token);
        return getEmailFromClaims(claims);
    }

    @Override
    public Date getTokenExpirationDate(String token) {
        return getClaimsFromToken(token).getExpiration();
    }

    private String getEmailFromClaims(Claims claims){
        return (String) claims.get("email");
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    }
}
