package dev.arnoldatse.opensource.look4dev.app.security;

import dev.arnoldatse.opensource.look4dev.app.security.mappers.MapperCoreUserProfileToSimpleGrantedAuthority;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperUserToUserTokenInfos;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    UserDetailsService customUserDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    private static final String AUTHENTICATION_ERROR_MESSAGE = "Bad credentials";


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {
            Optional<User> optionalUser = userRepository.findFirstByEmailOrPseudo(username);
            if (optionalUser.isPresent()) {
                User coreUser = optionalUser.get();
                if (passwordEncoder.matches(password, coreUser.getPassword())) {
                    UserTokenInfosDto userTokenInfos = new MapperUserToUserTokenInfos(coreUser).mapFromUser();
                    return new UsernamePasswordAuthenticationToken(
                            userTokenInfos,
                            password,
                            coreUser
                                    .getUserProfiles()
                                    .stream()
                                    .map(this::mapCoreUserProfileToSimpleGrantedAuthority)
                                    .collect(Collectors.toList())
                    );
                }
            }
            throw new BadCredentialsException(AUTHENTICATION_ERROR_MESSAGE);
        } catch (UsernameNotFoundException exception) {
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
