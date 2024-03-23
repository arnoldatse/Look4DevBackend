package dev.arnoldatse.opensource.look4dev.app.security;

import dev.arnoldatse.opensource.look4dev.app.security.mappers.MapperCoreUserProfileToSimpleGrantedAuthority;
import dev.arnoldatse.opensource.look4dev.core.auth.FailedAuthenticationException;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.users.UserPasswordEncoder;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.users.auth.usecases.AuthenticationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    UserDetailsService customUserDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPasswordEncoder userPasswordEncoder;

    private static final String AUTHENTICATION_ERROR_MESSAGE = "Bad credentials";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {
            User user = new AuthenticationUser(userRepository, userPasswordEncoder).authentication(username, password);
            return new UsernamePasswordAuthenticationToken(
                    user,
                    password,
                    user.getUserProfiles()
                            .stream()
                            .map(this::mapCoreUserProfileToSimpleGrantedAuthority)
                            .toList()
            );
        } catch (FailedAuthenticationException exception) {
            throw new BadCredentialsException(AUTHENTICATION_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    private SimpleGrantedAuthority mapCoreUserProfileToSimpleGrantedAuthority(UserProfile coreUserProfile) {
        return new MapperCoreUserProfileToSimpleGrantedAuthority(coreUserProfile).mapFromUserProfile();
    }
}
