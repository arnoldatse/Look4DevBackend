package dev.arnoldatse.opensource.look4dev.core.auth;

import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;

import java.util.Date;

public abstract class TokenManager {
    public static final long TOKEN_VALIDITY = 24 * 60 * 60;

    public abstract String generateToken(UserTokenInfosDto user);
    public abstract boolean validateToken(String token, String userEmail);
    public abstract String getTokenEmail(String token);
    public abstract Date getTokenExpirationDate(String token);
}
