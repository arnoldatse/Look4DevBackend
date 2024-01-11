package dev.arnoldatse.opensource.look4dev.core.users.usecases;

import dev.arnoldatse.opensource.look4dev.core.auth.UserRegistrationPasswordEncoder;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperToUser;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperUserRegisterRequestToUser;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperUserToUserResponse;
import dev.arnoldatse.opensource.look4dev.core.userProfile.UserProfileRepository;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserRegisterRequestDto;

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
        MapperToUser userRegisterRequestMapper = new MapperUserRegisterRequestToUser(userRegisterRequestDto, userProfileRepository, userRegistrationPasswordEncoder);
        User registeredUser = userRepository.saveUser(userRegisterRequestMapper.mapToUser());
        return new MapperUserToUserResponse(registeredUser).mapFromUser();
    }
}
