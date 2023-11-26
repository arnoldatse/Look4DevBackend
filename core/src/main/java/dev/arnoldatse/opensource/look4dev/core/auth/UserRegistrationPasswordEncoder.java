package dev.arnoldatse.opensource.look4dev.core.auth;

public interface UserRegistrationPasswordEncoder {
    String encode(String password);
}
