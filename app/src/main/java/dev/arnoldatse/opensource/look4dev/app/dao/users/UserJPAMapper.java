package dev.arnoldatse.opensource.look4dev.app.dao.users;

import dev.arnoldatse.opensource.look4dev.app.dao.userProfiles.UserProfileJPAUserProfileSimpleMapper;
import dev.arnoldatse.opensource.look4dev.app.entities.UserProfile;
import dev.arnoldatse.opensource.look4dev.app.entities.UserUserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.UserMapper;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileSimple;
import dev.arnoldatse.opensource.look4dev.core.mappers.MapperEntitiesSetable;

public class UserJPAMapper implements UserMapper<User, dev.arnoldatse.opensource.look4dev.app.entities.User.User>, MapperEntitiesSetable<User, dev.arnoldatse.opensource.look4dev.app.entities.User.User> {
    private dev.arnoldatse.opensource.look4dev.app.entities.User.User userJPA;
    private User coreUser;

    public UserJPAMapper(User coreUser, dev.arnoldatse.opensource.look4dev.app.entities.User.User userJPA) {
        this.userJPA = userJPA;
        this.coreUser = coreUser;
    }

    @Override
    public User mapToUser() {
        User user = new User();
        user.setId(userJPA.getId());
        user.setLastname(userJPA.getLastname());
        user.setFirstname(userJPA.getFirstname());
        user.setEmail(userJPA.getEmail());
        user.setPassword(userJPA.getPassword());
        user.setPseudo(userJPA.getPseudo());
        user.setPicture(userJPA.getPicture());
        user.setBio(userJPA.getBio());
        user.setCv(userJPA.getCv());
        user.setCreatedAt(userJPA.getCreatedAt());
        user.setUpdatedAt(userJPA.getUpdatedAt());
        user.setUserProfiles(userJPA.getUserUserProfiles().stream()
                .map(this::mapUserUserProfileToCoreUser).toList());

        return user;
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.app.entities.User.User mapToMatchUser() {
        dev.arnoldatse.opensource.look4dev.app.entities.User.User mappedUserJPA = new dev.arnoldatse.opensource.look4dev.app.entities.User.User();
        mappedUserJPA.setId(coreUser.getId());
        mappedUserJPA.setLastname(coreUser.getLastname());
        mappedUserJPA.setFirstname(coreUser.getFirstname());
        mappedUserJPA.setEmail(coreUser.getEmail());
        mappedUserJPA.setPassword(coreUser.getPassword());
        mappedUserJPA.setPseudo(coreUser.getPseudo());
        mappedUserJPA.setPicture(coreUser.getPicture());
        mappedUserJPA.setBio(coreUser.getBio());
        mappedUserJPA.setCv(coreUser.getCv());
        mappedUserJPA.setCreatedAt(coreUser.getCreatedAt());
        mappedUserJPA.setUpdatedAt(coreUser.getUpdatedAt());
        mappedUserJPA.setUserUserProfiles(coreUser.getUserProfiles().stream()
                .map(this::mapCoreUserToUserUserProfileSimple).toList());

        return mappedUserJPA;
    }

    @Override
    public void setMainEntity(User user) {
        this.coreUser = user;

    }

    @Override
    public void setMatchEntity(dev.arnoldatse.opensource.look4dev.app.entities.User.User userJPA) {
        this.userJPA = userJPA;
    }

    private UserProfileSimple mapUserUserProfileToCoreUser(UserUserProfile userUserProfile) {
        UserProfileJPAUserProfileSimpleMapper userProfileJPAUserProfileSImpleMapper = new UserProfileJPAUserProfileSimpleMapper(
                new UserProfileSimple(),
                userUserProfile.getUserProfile()
        );
        return userProfileJPAUserProfileSImpleMapper.mapToUserProfile();
    }

    private UserUserProfile mapCoreUserToUserUserProfileSimple(UserProfileSimple userProfileSimple) {
        UserProfileJPAUserProfileSimpleMapper userProfileJPAUserProfileSimpleMapper = new UserProfileJPAUserProfileSimpleMapper(
                userProfileSimple,
                new UserProfile()
        );

        UserProfile userProfile = userProfileJPAUserProfileSimpleMapper.mapToMatchUserProfile();
        UserUserProfile userUserProfile = new UserUserProfile();
        userUserProfile.setUser(this.userJPA);
        userUserProfile.setUserProfile(userProfile);

        return userUserProfile;
    }
}
