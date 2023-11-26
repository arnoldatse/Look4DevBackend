package dev.arnoldatse.opensource.look4dev.core.entities.user.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserResponseDto;

public class UserResponseMapper implements UserMapper<User, UserResponseDto> {
    private final UserResponseDto userResponse;
    private final User user;

    public UserResponseMapper(User user, UserResponseDto userResponse){
        this.user = user;
        this.userResponse = userResponse;
    }
    @Override
    public User mapToUser() {
        User mappedUser = new User();
        mappedUser.setId(userResponse.getId());
        mappedUser.setLastname(userResponse.getLastname());
        mappedUser.setFirstname(userResponse.getFirstname());
        mappedUser.setEmail(userResponse.getEmail());
        mappedUser.setPseudo(userResponse.getPseudo());
        mappedUser.setPicture(userResponse.getPicture());
        mappedUser.setBio(userResponse.getBio());
        mappedUser.setCv(userResponse.getCv());
        mappedUser.setCreatedAt(userResponse.getCreatedAt());
        mappedUser.setUpdatedAt(userResponse.getUpdatedAt());
        mappedUser.setUserProfiles(userResponse.getUserProfiles());

        return mappedUser;
    }

    @Override
    public UserResponseDto mapToMatchUser() {
        UserResponseDto mappedUserResponse = new UserResponseDto();
        mappedUserResponse.setId(user.getId());
        mappedUserResponse.setLastname(user.getLastname());
        mappedUserResponse.setFirstname(user.getFirstname());
        mappedUserResponse.setEmail(user.getEmail());
        mappedUserResponse.setPseudo(user.getPseudo());
        mappedUserResponse.setPicture(user.getPicture());
        mappedUserResponse.setBio(user.getBio());
        mappedUserResponse.setCv(user.getCv());
        mappedUserResponse.setCreatedAt(user.getCreatedAt());
        mappedUserResponse.setUpdatedAt(user.getUpdatedAt());
        mappedUserResponse.setUserProfiles(user.getUserProfiles());
        return mappedUserResponse;
    }
}
