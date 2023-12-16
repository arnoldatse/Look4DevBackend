package dev.arnoldatse.opensource.look4dev.core.users.usecases;

import dev.arnoldatse.opensource.look4dev.core.auth.AuthResponse;
import dev.arnoldatse.opensource.look4dev.core.auth.TokenManager;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileSimple;
import dev.arnoldatse.opensource.look4dev.core.http.FormatResponseDate;
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

    public AuthResponse authenticate() {
        String token = tokenManager.generateToken(userTokenInfosDto);
        String tokenExpirationDate = FormatResponseDate.format(tokenManager.getTokenExpirationDate(token));
        String email = tokenManager.getTokenEmail(token);
        Optional<User> optionalUser = userRepository.findFirstByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            this.initProfiles(user);
            return new AuthResponse(token, tokenExpirationDate, email, user.getPseudo(), profiles);
        }
        return null;
    }

    private void initProfiles(User user) {
        if (profiles == null) {
            this.profiles = user.getUserProfiles().stream().map(UserProfileSimple::getName).map(UserProfileName::getValue).toArray(String[]::new);
        }
    }
}
