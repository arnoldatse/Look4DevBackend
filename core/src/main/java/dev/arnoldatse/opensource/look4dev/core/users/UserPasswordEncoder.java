package dev.arnoldatse.opensource.look4dev.core.users;

public interface UserPasswordEncoder {
    String encode(String password);
    boolean matches(String passwordRequest, String encodedPassword);
}
