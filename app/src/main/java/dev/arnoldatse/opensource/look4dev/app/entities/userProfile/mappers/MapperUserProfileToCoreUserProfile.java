package dev.arnoldatse.opensource.look4dev.app.entities.userProfile.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperToUserProfile;

public class MapperUserProfileToCoreUserProfile implements MapperToUserProfile {
    private final UserProfile userProfile;

    public MapperUserProfileToCoreUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile mapToUserProfile() {
        dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile mappedUserProfileSimple = new dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile();
        mappedUserProfileSimple.setId(userProfile.getId());
        mappedUserProfileSimple.setName(userProfile.getName());
        mappedUserProfileSimple.setCreatedAt(userProfile.getCreatedAt());
        return mappedUserProfileSimple;
    }
}
