package dev.arnoldatse.opensource.look4dev.core.users.usecases;

import dev.arnoldatse.opensource.look4dev.core.auth.AuthResponse;
import dev.arnoldatse.opensource.look4dev.core.auth.TokenManager;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperUserProfileToString;
import dev.arnoldatse.opensource.look4dev.core.http.FormatResponseDate;
import dev.arnoldatse.opensource.look4dev.core.http.httpError.exceptions.NotFoundHttpErrorException;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;

import java.util.Optional;

public class AuthUser {
    private final TokenManager tokenManager;
    private final UserTokenInfosDto userTokenInfosDto;
    private final UserRepository userRepository;
    private String[] profiles;

    public AuthUser(TokenManager tokenManager, UserTokenInfosDto userTokenInfosDto, UserRepository userRepository, String[] profiles) {
        this.tokenManager = tokenManager;
        this.userTokenInfosDto = userTokenInfosDto;
        this.userRepository = userRepository;
        this.profiles = profiles;
    }

    public AuthResponse authenticate() throws NotFoundHttpErrorException {
        String token = tokenManager.generateToken(userTokenInfosDto);
        String tokenExpirationDate = FormatResponseDate.format(tokenManager.getTokenExpirationDate(token));
        Optional<User> optionalUser = userRepository.findFirstById(userTokenInfosDto.id());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            this.initProfiles(user);
            return new AuthResponse(token, tokenExpirationDate, user.getId(), user.getPseudo(), profiles);
        }
        throw new NotFoundHttpErrorException("User not found");
    }

    private void initProfiles(User user) {
        if (profiles == null) {
            this.profiles = user.getUserProfiles().stream().map(userProfile -> new MapperUserProfileToString(userProfile).toString()).toArray(String[]::new);
        }
    }
}
