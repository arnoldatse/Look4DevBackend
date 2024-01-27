package dev.arnoldatse.opensource.look4dev.core.users.usecases;

import dev.arnoldatse.opensource.look4dev.core.fileStorage.adapters.FileStorageUrlGetterAdapter;
import dev.arnoldatse.opensource.look4dev.core.users.UserPasswordEncoder;
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
    private final UserPasswordEncoder userPasswordEncoder;
    private final UserProfileRepository userProfileRepository;
    private final FileStorageUrlGetterAdapter fileStorageUrlGetterAdapter;

    public RegisterUser(UserRegisterRequestDto userRegisterRequestDto, UserRepository userRepository, UserPasswordEncoder userPasswordEncoder, UserProfileRepository userProfileRepository, FileStorageUrlGetterAdapter fileStorageUrlGetterAdapter){
        this.userRegisterRequestDto = userRegisterRequestDto;
        this.userRepository = userRepository;
        this.userPasswordEncoder = userPasswordEncoder;
        this.userProfileRepository = userProfileRepository;
        this.fileStorageUrlGetterAdapter = fileStorageUrlGetterAdapter;
    }

    public UserResponseDto register(){
        MapperToUser userRegisterRequestMapper = new MapperUserRegisterRequestToUser(userRegisterRequestDto, userProfileRepository, userPasswordEncoder);
        User registeredUser = userRepository.saveUser(userRegisterRequestMapper.mapToUser());
        return new MapperUserToUserResponse(registeredUser, fileStorageUrlGetterAdapter).mapFromUser();
    }
}
