package com.arnoldatse.look4dev.core.users.usecases;

import com.arnoldatse.look4dev.core.auth.UserRegistrationPasswordEncoder;
import com.arnoldatse.look4dev.core.entities.user.User;
import com.arnoldatse.look4dev.core.entities.user.dtos.UserResponseDto;
import com.arnoldatse.look4dev.core.entities.user.mappers.UserMapper;
import com.arnoldatse.look4dev.core.entities.user.mappers.UserRegisterRequestMapper;
import com.arnoldatse.look4dev.core.entities.user.mappers.UserResponseMapper;
import com.arnoldatse.look4dev.core.userProfile.UserProfileRepository;
import com.arnoldatse.look4dev.core.users.UserRepository;
import com.arnoldatse.look4dev.core.entities.user.dtos.UserRegisterRequestDto;

public class RegisterUser {
    private final UserRegisterRequestDto userRegisterRequestDto;
    private final UserRepository userRepository;
    private final UserRegistrationPasswordEncoder userRegistrationPasswordEncoder;
    private final UserProfileRepository userProfileRepository;

    public RegisterUser(UserRegisterRequestDto userRegisterRequestDto, UserRepository userRepository, UserRegistrationPasswordEncoder userRegistrationPasswordEncoder, UserProfileRepository userProfileRepository){
        this.userRegisterRequestDto = userRegisterRequestDto;
        this.userRepository = userRepository;
        this.userRegistrationPasswordEncoder = userRegistrationPasswordEncoder;
        this.userProfileRepository = userProfileRepository;
    }

    public UserResponseDto register(){
        UserMapper<User, UserRegisterRequestDto> userRegisterRequestMapper = new UserRegisterRequestMapper(new User(), userRegisterRequestDto, userProfileRepository, userRegistrationPasswordEncoder);
        User registeredUser = userRepository.saveUser(userRegisterRequestMapper.mapToUser());
        UserMapper<User, UserResponseDto> userResponseMapper = new UserResponseMapper(registeredUser, new UserResponseDto());
        return userResponseMapper.mapToMatchUser();
    }
}
