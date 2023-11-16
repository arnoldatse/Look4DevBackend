package com.arnoldatse.look4dev.core.users.usecases;

import com.arnoldatse.look4dev.core.auth.AuthResponse;
import com.arnoldatse.look4dev.core.auth.TokenManager;
import com.arnoldatse.look4dev.core.entities.user.User;
import com.arnoldatse.look4dev.core.entities.user.dtos.UserTokenInfosDto;
import com.arnoldatse.look4dev.core.entities.userProfile.UserProfileSimple;
import com.arnoldatse.look4dev.core.http.FormatResponseDate;
import com.arnoldatse.look4dev.core.users.UserRepository;

public class AuthUser {
    private final TokenManager tokenManager;
    private final UserTokenInfosDto userTokenInfosDto;
    private final UserRepository userRepository;
    private String[] profiles;

    public AuthUser(TokenManager tokenManager, UserTokenInfosDto userTokenInfosDto, UserRepository userRepository, String[] profiles){
        this.tokenManager = tokenManager;
        this.userTokenInfosDto = userTokenInfosDto;
        this.userRepository = userRepository;
        this.profiles = profiles;
    }

    public AuthResponse authenticate(){
        String token = tokenManager.generateToken(userTokenInfosDto);
        String tokenExpirationDate = FormatResponseDate.format(tokenManager.getTokenExpirationDate(token)) ;
        String email = tokenManager.getTokenEmail(token);
        User user = userRepository.findFirstByEmail(email);
        this.initProfiles(user);
        return new AuthResponse(token, tokenExpirationDate, email, user.getPseudo(), profiles);
    }

    private void initProfiles(User user){
        if(profiles == null){
            this.profiles = user.getUserProfiles().stream().map(UserProfileSimple::getName).toArray(String[]::new);
        }
    }
}
