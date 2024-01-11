package dev.arnoldatse.opensource.look4dev.core.auth;

import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;

import java.util.Date;

public interface TokenManager {
    long TOKEN_VALIDITY = 24 * 60 * 60;
    String userIdClaim = "userId";
    String generateToken(UserTokenInfosDto user);
    boolean validateToken(String token, String userId);
    String getTokenUserId(String token);
    Date getTokenExpirationDate(String token);
}
