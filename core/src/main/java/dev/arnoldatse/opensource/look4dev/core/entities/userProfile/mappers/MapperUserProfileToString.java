package dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;

public class MapperUserProfileToString implements MapperFromUserProfile<String>{
    private final UserProfile userProfile;

    public MapperUserProfileToString(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String mapFromUserProfile() {
        return userProfile.getName().getValue();
    }
}
