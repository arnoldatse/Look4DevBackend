package dev.arnoldatse.opensource.look4dev.core.entities.user.mappers;

import dev.arnoldatse.opensource.look4dev.core.users.UserPasswordEncoder;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserRegisterRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.userProfile.UserProfileRepository;

import java.util.List;

public class MapperUserRegisterRequestToUser implements MapperToUser {
    private final UserRegisterRequestDto userRegisterRequestDto;
    private final UserPasswordEncoder userPasswordEncoder;
    private final UserProfileRepository userProfileRepository;

    public MapperUserRegisterRequestToUser(UserRegisterRequestDto userRegisterRequestDto, UserProfileRepository userProfileRepository, UserPasswordEncoder userPasswordEncoder){
        this.userRegisterRequestDto = userRegisterRequestDto;
        this.userProfileRepository = userProfileRepository;
        this.userPasswordEncoder = userPasswordEncoder;
    }

    @Override
    public User mapToUser() {
        User mappedUser = new User();

        List<UserProfile> userProfileSimpleList = userProfileRepository.findAllById(userRegisterRequestDto.getUserProfilesIds());

        mappedUser.setLastname(userRegisterRequestDto.getLastname());
        mappedUser.setFirstname(userRegisterRequestDto.getFirstname());
        mappedUser.setEmail(userRegisterRequestDto.getEmail());
        mappedUser.setPassword(userPasswordEncoder.encode(userRegisterRequestDto.getPassword()));
        mappedUser.setUserProfiles(userProfileSimpleList);
        return mappedUser;
    }
}
