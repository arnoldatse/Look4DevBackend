package dev.arnoldatse.opensource.look4dev.core.entities.user.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.dtos.UserProfileResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperUserProfileToUserProfileResponse;

public class MapperUserToUserResponse implements MapperFromUser<UserResponseDto> {
    private final User user;

    public MapperUserToUserResponse(User user){
        this.user = user;
    }

    @Override
    public UserResponseDto mapFromUser() {
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
        mappedUserResponse.setUserProfiles(user.getUserProfiles().stream().map(this::mapUserProfileToUserProfileResponse).toList());
        return mappedUserResponse;
    }

    private UserProfileResponseDto mapUserProfileToUserProfileResponse(UserProfile userProfile){
        return new MapperUserProfileToUserProfileResponse(userProfile).mapFromUserProfile();
    }
}
