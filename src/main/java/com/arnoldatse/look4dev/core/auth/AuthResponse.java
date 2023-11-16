package com.arnoldatse.look4dev.core.auth;

public record AuthResponse(String token, String tokenExpirationDate, String email, String pseudo, String[] profiles) {
}
