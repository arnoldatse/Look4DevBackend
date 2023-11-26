package dev.arnoldatse.opensource.look4dev.core.entities.user.mappers;

import dev.arnoldatse.opensource.look4dev.core.auth.UserRegistrationPasswordEncoder;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserRegisterRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileSimple;
import dev.arnoldatse.opensource.look4dev.core.userProfile.UserProfileRepository;

import java.util.List;

public class UserRegisterRequestMapper implements UserMapper<User, UserRegisterRequestDto>{
    UserRegisterRequestDto userRegisterRequestDto;
    User user;
    private final UserRegistrationPasswordEncoder userRegistrationPasswordEncoder;
    private final UserProfileRepository userProfileRepository;

    public UserRegisterRequestMapper(User user, UserRegisterRequestDto userRegisterRequestDto, UserProfileRepository userProfileRepository, UserRegistrationPasswordEncoder userRegistrationPasswordEncoder){
        this.user = user;
        this.userRegisterRequestDto = userRegisterRequestDto;
        this.userProfileRepository = userProfileRepository;
        this.userRegistrationPasswordEncoder = userRegistrationPasswordEncoder;
    }

    @Override
    public User mapToUser() {
        User mappedUser = new User();

        List<UserProfileSimple> userProfileSimpleList = userProfileRepository.findAllById(userRegisterRequestDto.getUserProfilesIds());

        mappedUser.setLastname(userRegisterRequestDto.getLastname());
        mappedUser.setFirstname(userRegisterRequestDto.getFirstname());
        mappedUser.setEmail(userRegisterRequestDto.getEmail());
        mappedUser.setPassword(userRegistrationPasswordEncoder.encode(userRegisterRequestDto.getPassword()));
        mappedUser.setUserProfiles(userProfileSimpleList);
        return mappedUser;
    }

    @Override
    public UserRegisterRequestDto mapToMatchUser() {
        return null;
    }
}
