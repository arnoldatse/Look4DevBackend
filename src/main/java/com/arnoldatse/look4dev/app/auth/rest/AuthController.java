package com.arnoldatse.look4dev.app.auth.rest;

import com.arnoldatse.look4dev.app.auth.services.AuthService;
import com.arnoldatse.look4dev.core.auth.AuthResponse;
import com.arnoldatse.look4dev.core.auth.CredentialsRequest;
import com.arnoldatse.look4dev.core.entities.user.dtos.UserRegisterRequestDto;
import com.arnoldatse.look4dev.core.entities.user.dtos.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRegisterRequestDto userRegister){
        return authService.register(userRegister);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody CredentialsRequest credentialsRequest){
        return authService.login(credentialsRequest);
    }
}
