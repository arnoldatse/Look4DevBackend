package dev.arnoldatse.opensource.look4dev.core.entities.user.updaters;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.PasswordUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.users.UserPasswordEncoder;

import java.util.Arrays;

public class UpdateUserWithPasswordUpdateRequestDto {
    private final User user;
    private final PasswordUpdateRequestDto passwordUpdateRequestDto;
    private final UserPasswordEncoder userPasswordEncoder;

    public UpdateUserWithPasswordUpdateRequestDto(User user, PasswordUpdateRequestDto passwordUpdateRequestDto, UserPasswordEncoder userPasswordEncoder) {
        this.user = user;
        this.passwordUpdateRequestDto = passwordUpdateRequestDto;
        this.userPasswordEncoder = userPasswordEncoder;
    }

    public void update(){
        user.setPassword(userPasswordEncoder.encode(passwordUpdateRequestDto.getPassword()));
    }
}
