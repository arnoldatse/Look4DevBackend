package dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;

public class MapperUserProfileToInt implements MapperFromUserProfile<Integer>{
    private final UserProfile userProfile;

    public MapperUserProfileToInt(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public Integer mapFromUserProfile() {
        return userProfile.getId();
    }
}
