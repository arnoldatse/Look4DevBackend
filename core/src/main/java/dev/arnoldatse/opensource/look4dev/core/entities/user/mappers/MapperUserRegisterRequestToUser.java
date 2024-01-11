package dev.arnoldatse.opensource.look4dev.core.entities.user.mappers;

import dev.arnoldatse.opensource.look4dev.core.auth.UserRegistrationPasswordEncoder;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserRegisterRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.userProfile.UserProfileRepository;

import java.util.List;

public class MapperUserRegisterRequestToUser implements MapperToUser {
    private final UserRegisterRequestDto userRegisterRequestDto;
    private final UserRegistrationPasswordEncoder userRegistrationPasswordEncoder;
    private final UserProfileRepository userProfileRepository;

    public MapperUserRegisterRequestToUser(UserRegisterRequestDto userRegisterRequestDto, UserProfileRepository userProfileRepository, UserRegistrationPasswordEncoder userRegistrationPasswordEncoder){
        this.userRegisterRequestDto = userRegisterRequestDto;
        this.userProfileRepository = userProfileRepository;
        this.userRegistrationPasswordEncoder = userRegistrationPasswordEncoder;
    }

    @Override
    public User mapToUser() {
        User mappedUser = new User();

        List<UserProfile> userProfileSimpleList = userProfileRepository.findAllById(userRegisterRequestDto.getUserProfilesIds());

        mappedUser.setLastname(userRegisterRequestDto.getLastname());
        mappedUser.setFirstname(userRegisterRequestDto.getFirstname());
        mappedUser.setEmail(userRegisterRequestDto.getEmail());
        mappedUser.setPassword(userRegistrationPasswordEncoder.encode(userRegisterRequestDto.getPassword()));
        mappedUser.setUserProfiles(userProfileSimpleList);
        return mappedUser;
    }
}
