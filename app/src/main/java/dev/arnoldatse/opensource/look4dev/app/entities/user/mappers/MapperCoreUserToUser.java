package dev.arnoldatse.opensource.look4dev.app.entities.user.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.userProfile.mappers.MapperCoreUserProfileToUserProfile;
import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlOtherPlatform.mappers.MapperCoreUserUrlOtherPlatformToUserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlSupportedPlatform.mappers.MapperCoreUserUrlSupportedPlatformToUserUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import dev.arnoldatse.opensource.look4dev.app.entities.UserUserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperFromUser;

public class MapperCoreUserToUser implements MapperFromUser<User> {
    private final dev.arnoldatse.opensource.look4dev.core.entities.user.User coreUser;

    public MapperCoreUserToUser(dev.arnoldatse.opensource.look4dev.core.entities.user.User user) {
        this.coreUser = user;
    }

    @Override
    public User mapFromUser() {
        User mappedUser = new User();
        mappedUser.setId(coreUser.getId());
        mappedUser.setLastname(coreUser.getLastname());
        mappedUser.setFirstname(coreUser.getFirstname());
        mappedUser.setEmail(coreUser.getEmail());
        mappedUser.setPassword(coreUser.getPassword());
        mappedUser.setPseudo(coreUser.getPseudo());
        mappedUser.setPicture(coreUser.getPicture());
        mappedUser.setBio(coreUser.getBio());
        mappedUser.setCv(coreUser.getCv());
        mappedUser.setCreatedAt(coreUser.getCreatedAt());
        mappedUser.setUpdatedAt(coreUser.getUpdatedAt());
        mappedUser.setUserUserProfiles(coreUser.getUserProfiles().stream()
                .map(this::mapCoreUserProfileToUserUserProfile).toList());
        if (coreUser.getPlatformsUrls() != null) {
            mappedUser.setOtherPlatformUrls(
                    coreUser.getPlatformsUrls().getUrlOtherPlatforms().stream().map(
                            userUrlOtherPlatform -> new MapperCoreUserUrlOtherPlatformToUserUrlOtherPlatform(userUrlOtherPlatform).mapFromUserUrlOtherPlatform()
                    ).toList()
            );
            mappedUser.setSupportedPlatformUrls(
                    coreUser.getPlatformsUrls().getUrlSupportedPlatforms().stream().map(
                            userUrlSupportedPlatform -> new MapperCoreUserUrlSupportedPlatformToUserUrlSupportedPlatform(userUrlSupportedPlatform).mapFromUserUrlSupportedPlatform()
                    ).toList()
            );
        }


        return mappedUser;
    }

    private UserUserProfile mapCoreUserProfileToUserUserProfile(dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile coreUserProfile) {
        UserUserProfile userUserProfile = new UserUserProfile();
        userUserProfile.setUserProfile(new MapperCoreUserProfileToUserProfile(coreUserProfile).mapFromUserProfile());
        return userUserProfile;
    }
}
