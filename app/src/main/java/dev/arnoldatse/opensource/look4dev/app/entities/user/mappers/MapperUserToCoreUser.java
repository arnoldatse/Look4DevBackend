package dev.arnoldatse.opensource.look4dev.app.entities.user.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.userProfile.mappers.MapperUserProfileToCoreUserProfile;
import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlOtherPlatform.mappers.MapperUserUrlOtherPlatformToCoreUserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlSupportedPlatform.mappers.MapperUserUrlSupportedPlatformToCoreUserUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import dev.arnoldatse.opensource.look4dev.app.entities.UserUserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperToUser;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperToUserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.UserUrlPlatforms;

public class MapperUserToCoreUser implements MapperToUser {
    private final User user;

    public MapperUserToCoreUser(User user) {
        this.user = user;
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.user.User mapToUser() {
        dev.arnoldatse.opensource.look4dev.core.entities.user.User mappedCoreUser = new dev.arnoldatse.opensource.look4dev.core.entities.user.User();
        mappedCoreUser.setId(user.getId());
        mappedCoreUser.setLastname(user.getLastname());
        mappedCoreUser.setFirstname(user.getFirstname());
        mappedCoreUser.setEmail(user.getEmail());
        mappedCoreUser.setPassword(user.getPassword());
        mappedCoreUser.setPseudo(user.getPseudo());
        mappedCoreUser.setPicture(user.getPicture());
        mappedCoreUser.setBio(user.getBio());
        mappedCoreUser.setCv(user.getCv());
        mappedCoreUser.setCreatedAt(user.getCreatedAt());
        mappedCoreUser.setUpdatedAt(user.getUpdatedAt());
        mappedCoreUser.setUserProfiles(user.getUserUserProfiles().stream()
                .map(this::mapUserUserProfileToCoreUser).toList());
        mappedCoreUser.setPlatformsUrls(getUserUrlPlatformsFormUser());
        return mappedCoreUser;
    }

    private UserProfile mapUserUserProfileToCoreUser(UserUserProfile userUserProfile) {
        MapperToUserProfile mapperUserProfileToCoreUserProfileSimple = new MapperUserProfileToCoreUserProfile(
                userUserProfile.getUserProfile()
        );
        return mapperUserProfileToCoreUserProfileSimple.mapToUserProfile();
    }

    private UserUrlPlatforms getUserUrlPlatformsFormUser() {
        UserUrlPlatforms userUrlPlatforms = new UserUrlPlatforms();
        if (user.getOtherPlatformUrls() != null) {
            userUrlPlatforms.setUrlOtherPlatforms(
                    user.getOtherPlatformUrls().stream().map(
                            userUrlOtherPlatform -> new MapperUserUrlOtherPlatformToCoreUserUrlOtherPlatform(userUrlOtherPlatform).mapToUserUrlOtherPlatform()
                    ).toList()
            );
        }
        if (user.getSupportedPlatformUrls() != null) {
            userUrlPlatforms.setUrlSupportedPlatforms(
                    user.getSupportedPlatformUrls().stream().map(
                            userUrlSupportedPlatform -> new MapperUserUrlSupportedPlatformToCoreUserUrlSupportedPlatform(userUrlSupportedPlatform).mapToUserUrlSupportedPlatform()
                    ).toList()
            );
        }

        return userUrlPlatforms;

    }
}
