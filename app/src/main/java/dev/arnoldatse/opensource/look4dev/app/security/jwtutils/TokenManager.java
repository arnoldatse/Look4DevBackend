package dev.arnoldatse.opensource.look4dev.app.security.jwtutils;

import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Service
public class TokenManager implements dev.arnoldatse.opensource.look4dev.core.auth.TokenManager, Serializable {
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
        try {
            Claims claims = getClaimsFromToken(token);
            String email = getEmailFromClaims(claims);
            boolean isTokenExpired = claims.getExpiration().before(new Date());
            return (email.equals(userEmail) && !isTokenExpired);
        }
        catch (JwtException jwtException){
            return false;
        }

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

    private Claims getClaimsFromToken(String token) throws JwtException {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    }
}
