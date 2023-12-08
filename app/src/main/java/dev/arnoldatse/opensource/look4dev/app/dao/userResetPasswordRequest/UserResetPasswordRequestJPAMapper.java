package dev.arnoldatse.opensource.look4dev.app.dao.userResetPasswordRequest;

import dev.arnoldatse.opensource.look4dev.app.dao.users.UserJPAMapper;
import dev.arnoldatse.opensource.look4dev.core.entities.UserResetPasswordRequest.UserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.core.entities.UserResetPasswordRequest.mappers.UserResetPasswordRequestMapper;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.mappers.MapperEntitiesSetable;

public class UserResetPasswordRequestJPAMapper implements UserResetPasswordRequestMapper<UserResetPasswordRequest, dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest>, MapperEntitiesSetable<UserResetPasswordRequest, dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest> {

    private UserResetPasswordRequest userResetPasswordRequestCore;
    private dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest userResetPasswordRequestJPA;

    public UserResetPasswordRequestJPAMapper(UserResetPasswordRequest userResetPasswordRequestCore, dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest userResetPasswordRequestJPA){
        this.userResetPasswordRequestCore = userResetPasswordRequestCore;
        this.userResetPasswordRequestJPA = userResetPasswordRequestJPA;
    }

    @Override
    public UserResetPasswordRequest mapToUserResetPasswordRequest() {
        UserJPAMapper userJPAMapper = new UserJPAMapper(new User(), userResetPasswordRequestJPA.getUser());
        return new UserResetPasswordRequest(
                userResetPasswordRequestJPA.getId(),
                userResetPasswordRequestJPA.getExpirationDate(),
                userResetPasswordRequestJPA.getCreatedAt(),
                userJPAMapper.mapToUser()
        );
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest mapToMatchUserResetPasswordRequest() {
        UserJPAMapper userJPAMapper = new UserJPAMapper(userResetPasswordRequestCore.getUser(), new dev.arnoldatse.opensource.look4dev.app.entities.User());
        dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest userResetPasswordRequestJPA = new dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest();
        userResetPasswordRequestJPA.setExpirationDate(userResetPasswordRequestCore.getExpirationDate());
        userResetPasswordRequestJPA.setUser(userJPAMapper.mapToMatchUser());
        return userResetPasswordRequestJPA;
    }

    @Override
    public void setMainEntity(UserResetPasswordRequest userResetPasswordRequest) {
        this.userResetPasswordRequestCore = userResetPasswordRequest;
    }

    @Override
    public void setMatchEntity(dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest userResetPasswordRequest) {
        this.userResetPasswordRequestJPA = userResetPasswordRequest;
    }
}
