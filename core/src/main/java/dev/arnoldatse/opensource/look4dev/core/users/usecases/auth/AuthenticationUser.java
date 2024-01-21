package dev.arnoldatse.opensource.look4dev.core.users.usecases.auth;

import dev.arnoldatse.opensource.look4dev.core.auth.FailedAuthenticationException;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.users.UserPasswordEncoder;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;

import java.util.Optional;

public class AuthenticationUser {
    private final UserRepository userRepository;
    private final UserPasswordEncoder userPasswordEncoder;

    public AuthenticationUser(UserRepository userRepository, UserPasswordEncoder userPasswordEncoder) {
        this.userRepository = userRepository;
        this.userPasswordEncoder = userPasswordEncoder;
    }

    public User authentication(String login, String passwordRequest) throws FailedAuthenticationException {
        Optional<User> optionalUser = userRepository.findFirstByEmailOrPseudo(login);
        if(optionalUser.isPresent() && userPasswordEncoder.matches(passwordRequest, optionalUser.get().getPassword()) ){
            return optionalUser.get();
        }
        throw new FailedAuthenticationException("Bad Credentials");
    }
}
