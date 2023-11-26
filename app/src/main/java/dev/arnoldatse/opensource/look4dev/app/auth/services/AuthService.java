package dev.arnoldatse.opensource.look4dev.app.auth.services;

import dev.arnoldatse.opensource.look4dev.core.auth.AuthResponse;
import dev.arnoldatse.opensource.look4dev.core.auth.CredentialsRequest;
import dev.arnoldatse.opensource.look4dev.core.auth.TokenManager;
import dev.arnoldatse.opensource.look4dev.core.auth.UserRegistrationPasswordEncoder;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserRegisterRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;
import dev.arnoldatse.opensource.look4dev.core.userProfile.UserProfileRepository;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.users.usecases.AuthUser;
import dev.arnoldatse.opensource.look4dev.core.users.usecases.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    TokenManager tokenManager;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRegistrationPasswordEncoder userRegistrationPasswordEncoder;
    @Autowired
    UserProfileRepository userProfileRepository;

    public UserResponseDto register(UserRegisterRequestDto userRegisterRequestDto) {
        RegisterUser registerUser = new RegisterUser(userRegisterRequestDto, userRepository, userRegistrationPasswordEncoder, userProfileRepository);
        return registerUser.register();
    }

    public AuthResponse login(CredentialsRequest credentialsRequest) throws BadCredentialsException {
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(
                credentialsRequest.getLogin(),
                credentialsRequest.getPassword()
        );
        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
        UserTokenInfosDto userTokenInfosDto = new UserTokenInfosDto((String) authenticationResponse.getPrincipal());
        String[] profiles = authenticationResponse.getAuthorities().stream()
                .map(authority -> authority.getAuthority().substring(5))
                .toArray(String[]::new);
        return new AuthUser(tokenManager, userTokenInfosDto, userRepository, profiles).authenticate();
    }
}
