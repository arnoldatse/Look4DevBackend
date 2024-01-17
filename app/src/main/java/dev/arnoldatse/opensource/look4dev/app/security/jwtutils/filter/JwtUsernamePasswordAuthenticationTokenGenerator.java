package dev.arnoldatse.opensource.look4dev.app.security.jwtutils.filter;

import dev.arnoldatse.opensource.look4dev.app.dao.userUserProfile.UserUserProfileRepository;
import dev.arnoldatse.opensource.look4dev.app.dao.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.app.entities.UserUserProfile;
import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import dev.arnoldatse.opensource.look4dev.app.security.mappers.MapperUserProfileToSimpleGrantedAuthority;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;
import dev.arnoldatse.opensource.look4dev.core.http.exceptions.NotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtUsernamePasswordAuthenticationTokenGenerator {
    private final String userId;
    private final UserRepository userRepository;
    private final UserUserProfileRepository userUserProfileRepository;

    public JwtUsernamePasswordAuthenticationTokenGenerator(String userId, UserRepository userRepository, UserUserProfileRepository userUserProfileRepository) {
        this.userId = userId;
        this.userRepository = userRepository;
        this.userUserProfileRepository = userUserProfileRepository;
    }

    public Authentication generate() throws NotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            UserTokenInfosDto userTokenInfos = new UserTokenInfosDto(optionalUser.get().getId());
            Set<SimpleGrantedAuthority> simpleGrantedAuthorities = userUserProfileRepository.findByUserId(userId)
                    .stream()
                    .map(UserUserProfile::getUserProfile)
                    .map(userProfile -> new MapperUserProfileToSimpleGrantedAuthority(userProfile)
                            .mapFromUserProfile())
                    .collect(Collectors.toSet());

            return new UsernamePasswordAuthenticationToken(
                    userTokenInfos,
                    null,
                    simpleGrantedAuthorities
            );
        }
        throw new NotFoundException("User not found");
    }

}
