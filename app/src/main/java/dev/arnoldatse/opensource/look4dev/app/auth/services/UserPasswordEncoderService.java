package dev.arnoldatse.opensource.look4dev.app.auth.services;

import dev.arnoldatse.opensource.look4dev.core.auth.UserRegistrationPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserPasswordEncoderService implements UserRegistrationPasswordEncoder {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
