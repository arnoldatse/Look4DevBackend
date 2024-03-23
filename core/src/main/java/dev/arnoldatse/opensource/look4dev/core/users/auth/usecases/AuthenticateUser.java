package dev.arnoldatse.opensource.look4dev.core.users.auth.usecases;

import dev.arnoldatse.opensource.look4dev.core.auth.AuthResponse;
import dev.arnoldatse.opensource.look4dev.core.auth.TokenManager;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperUserToUserTokenInfos;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperUserProfileToString;
import dev.arnoldatse.opensource.look4dev.core.http.FormatResponseDate;

public class AuthenticateUser {
    private final TokenManager tokenManager;
    private final User user;

    public AuthenticateUser(User user, TokenManager tokenManager) {
        this.tokenManager = tokenManager;
        this.user = user;
    }

    public AuthResponse authenticate() {
        UserTokenInfosDto userTokenInfos = new MapperUserToUserTokenInfos(user).mapFromUser();
        String token = tokenManager.generateToken(userTokenInfos);
        String tokenExpirationDate = FormatResponseDate.format(tokenManager.getTokenExpirationDate(token));
        return new AuthResponse(token, tokenExpirationDate, user.getId(), user.getPseudo(), this.getUserProfiles(user));
    }

    private String[] getUserProfiles(User user) {
        return user.getUserProfiles().stream().map(userProfile -> new MapperUserProfileToString(userProfile).mapFromUserProfile()).toArray(String[]::new);
    }
}
