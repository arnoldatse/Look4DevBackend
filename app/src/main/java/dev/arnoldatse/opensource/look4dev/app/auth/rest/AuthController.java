package dev.arnoldatse.opensource.look4dev.app.auth.rest;

import dev.arnoldatse.opensource.look4dev.app.auth.services.UserResetPasswordRequestService;
import dev.arnoldatse.opensource.look4dev.app.exceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.auth.AuthResponse;
import dev.arnoldatse.opensource.look4dev.core.auth.CredentialsRequest;
import dev.arnoldatse.opensource.look4dev.app.auth.services.AuthService;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserIdToFindRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserRegisterRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserResponseDto;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserResetPasswordRequestService userResetPasswordRequestService;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRegisterRequestDto userRegister){
        return authService.register(userRegister);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody CredentialsRequest credentialsRequest){
        return authService.login(credentialsRequest);
    }

    @PostMapping("reset-password/request")
    public DefaultHttpSuccess resetPasswordRequest(@RequestBody UserIdToFindRequestDto userIdToFindRequestDto) throws NotFoundException {
        return userResetPasswordRequestService.create(userIdToFindRequestDto);
    }
}
