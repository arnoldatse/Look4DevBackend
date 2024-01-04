package dev.arnoldatse.opensource.look4dev.app.entities.userProfile.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperFromUserProfile;

public class MapperCoreUserProfileToUserProfile implements MapperFromUserProfile<UserProfile> {
    private final dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile coreUserProfile;

    public MapperCoreUserProfileToUserProfile(dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile coreUserProfile) {
        this.coreUserProfile = coreUserProfile;
    }

    @Override
    public UserProfile mapFromUserProfile() {
        UserProfile mappedUserProfileJPA = new UserProfile();
        mappedUserProfileJPA.setId(coreUserProfile.getId());
        mappedUserProfileJPA.setName(coreUserProfile.getName());
        mappedUserProfileJPA.setCreatedAt(coreUserProfile.getCreatedAt());
        return mappedUserProfileJPA;
    }
}
