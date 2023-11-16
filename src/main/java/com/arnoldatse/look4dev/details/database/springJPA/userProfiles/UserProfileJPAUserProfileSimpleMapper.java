package com.arnoldatse.look4dev.details.database.springJPA.userProfiles;

import com.arnoldatse.look4dev.app.entities.UserProfile;
import com.arnoldatse.look4dev.core.entities.userProfile.UserProfileSimple;
import com.arnoldatse.look4dev.core.entities.userProfile.mappers.UserProfileMapper;

public class UserProfileJPAUserProfileSimpleMapper implements UserProfileMapper<UserProfileSimple, UserProfile> {
    UserProfile userProfileJPA;
    UserProfileSimple coreUserProfileSimple;

    public UserProfileJPAUserProfileSimpleMapper(UserProfileSimple coreUserProfileSimple, UserProfile userProfileJPA){
        this.coreUserProfileSimple = coreUserProfileSimple;
        this.userProfileJPA = userProfileJPA;
    }

    @Override
    public UserProfileSimple mapToUserProfile() {
        UserProfileSimple mappedUserProfileSimple = new UserProfileSimple();
        mappedUserProfileSimple.setId(userProfileJPA.getId());
        mappedUserProfileSimple.setName(userProfileJPA.getName());
        mappedUserProfileSimple.setCreatedAt(userProfileJPA.getCreatedAt());
        return mappedUserProfileSimple;
    }

    @Override
    public UserProfile mapToMatchUserProfile() {
        UserProfile mappedUserProfileJPA = new UserProfile();
        mappedUserProfileJPA.setId(coreUserProfileSimple.getId());
        mappedUserProfileJPA.setName(coreUserProfileSimple.getName());
        mappedUserProfileJPA.setCreatedAt(coreUserProfileSimple.getCreatedAt());
        return mappedUserProfileJPA;
    }
}
