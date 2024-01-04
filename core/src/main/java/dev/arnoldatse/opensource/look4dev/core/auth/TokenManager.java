package dev.arnoldatse.opensource.look4dev.core.auth;

import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;

import java.util.Date;

public interface TokenManager {
    public final long TOKEN_VALIDITY = 24 * 60 * 60;
    public String generateToken(UserTokenInfosDto user);
    public boolean validateToken(String token, String userEmail);
    public String getTokenEmail(String token);
    public Date getTokenExpirationDate(String token);
}
