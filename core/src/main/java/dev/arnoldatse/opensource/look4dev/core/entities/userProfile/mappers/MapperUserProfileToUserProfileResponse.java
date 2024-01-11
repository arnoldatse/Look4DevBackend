package dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.dtos.UserProfileResponseDto;

public class MapperUserProfileToUserProfileResponse implements MapperFromUserProfile<UserProfileResponseDto>{
    private final UserProfile userProfile;

    public MapperUserProfileToUserProfileResponse(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public UserProfileResponseDto mapFromUserProfile() {
        UserProfileResponseDto mappedUserProfileResponseDto = new UserProfileResponseDto();
        mappedUserProfileResponseDto.setId(userProfile.getId());
        mappedUserProfileResponseDto.setName(userProfile.getName());
        mappedUserProfileResponseDto.setCreatedAt(userProfile.getCreatedAt());
        return mappedUserProfileResponseDto;
    }
}
