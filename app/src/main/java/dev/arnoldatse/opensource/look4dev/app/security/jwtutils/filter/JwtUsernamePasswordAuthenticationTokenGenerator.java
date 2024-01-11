package dev.arnoldatse.opensource.look4dev.app.security.jwtutils.filter;

import dev.arnoldatse.opensource.look4dev.app.dao.userUserProfile.UserUserProfileRepository;
import dev.arnoldatse.opensource.look4dev.app.dao.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.app.entities.UserUserProfile;
import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import dev.arnoldatse.opensource.look4dev.app.security.FilterAuthenticationGenerator;
import dev.arnoldatse.opensource.look4dev.app.security.mappers.MapperUserProfileToSimpleGrantedAuthority;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;
import dev.arnoldatse.opensource.look4dev.core.http.httpError.exceptions.NotFoundHttpErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JwtUsernamePasswordAuthenticationTokenGenerator implements FilterAuthenticationGenerator {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserUserProfileRepository userUserProfileRepository;

    @Override
    public Authentication generate(String userId) throws NotFoundHttpErrorException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            UserTokenInfosDto userTokenInfos = new UserTokenInfosDto(optionalUser.get().getId());
            Set<SimpleGrantedAuthority> simpleGrantedAuthorities = userUserProfileRepository.findByUserId(userId)
                    .stream()
                    .map(UserUserProfile::getUserProfile)
                    .map(
                            userProfile ->
                                    new MapperUserProfileToSimpleGrantedAuthority(userProfile).mapFromUserProfile())
                    .collect(Collectors.toSet());

            return new UsernamePasswordAuthenticationToken(
                    userTokenInfos,
                    null,
                    simpleGrantedAuthorities
            );
        }
        throw new NotFoundHttpErrorException("User not found");
    }

}
