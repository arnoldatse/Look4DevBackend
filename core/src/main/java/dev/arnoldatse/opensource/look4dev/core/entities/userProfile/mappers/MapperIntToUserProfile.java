package dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;

public class MapperIntToUserProfile implements MapperToUserProfile{
    private final int userProfileId;

    public MapperIntToUserProfile(int userProfileId) {
        this.userProfileId = userProfileId;
    }

    @Override
    public UserProfile mapToUserProfile() {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(userProfileId);
        return userProfile;
    }
}
