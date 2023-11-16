package com.arnoldatse.look4dev.details.database.springJPA.users;

import com.arnoldatse.look4dev.app.auth.services.UserPasswordEncoderService;
import com.arnoldatse.look4dev.app.entities.UserProfile;
import com.arnoldatse.look4dev.app.entities.UserUserProfile;
import com.arnoldatse.look4dev.core.auth.UserRegistrationPasswordEncoder;
import com.arnoldatse.look4dev.core.entities.user.User;
import com.arnoldatse.look4dev.core.entities.user.mappers.UserMapper;
import com.arnoldatse.look4dev.core.entities.userProfile.UserProfileSimple;
import com.arnoldatse.look4dev.core.mappers.MapperEntitiesSetable;
import com.arnoldatse.look4dev.details.database.springJPA.userProfiles.UserProfileJPAUserProfileSimpleMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserJPAMapper implements UserMapper<User, com.arnoldatse.look4dev.app.entities.User.User>, MapperEntitiesSetable<User, com.arnoldatse.look4dev.app.entities.User.User> {
    private com.arnoldatse.look4dev.app.entities.User.User userJPA;
    private User coreUser;

    public UserJPAMapper(User coreUser, com.arnoldatse.look4dev.app.entities.User.User userJPA) {
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
    public com.arnoldatse.look4dev.app.entities.User.User mapToMatchUser() {
        com.arnoldatse.look4dev.app.entities.User.User mappedUserJPA = new com.arnoldatse.look4dev.app.entities.User.User();
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
    public void setMatchEntity(com.arnoldatse.look4dev.app.entities.User.User userJPA) {
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
