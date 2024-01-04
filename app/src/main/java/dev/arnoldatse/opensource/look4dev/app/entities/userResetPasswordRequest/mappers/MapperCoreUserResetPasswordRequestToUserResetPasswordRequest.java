package dev.arnoldatse.opensource.look4dev.app.entities.userResetPasswordRequest.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.user.mappers.MapperCoreUserToUser;
import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import dev.arnoldatse.opensource.look4dev.app.entities.userResetPasswordRequest.UserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperFromUser;
import dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.mappers.MapperFromUserResetPasswordRequest;

public class MapperCoreUserResetPasswordRequestToUserResetPasswordRequest implements MapperFromUserResetPasswordRequest<UserResetPasswordRequest> {
    private final dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest userResetPasswordRequestCore;

    public MapperCoreUserResetPasswordRequestToUserResetPasswordRequest(dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest userResetPasswordRequestCore) {
        this.userResetPasswordRequestCore = userResetPasswordRequestCore;
    }

    @Override
    public UserResetPasswordRequest mapFromUserResetPasswordRequest() {
        MapperFromUser<User> coreUserToUserMapper = new MapperCoreUserToUser(userResetPasswordRequestCore.getUser());
        UserResetPasswordRequest userResetPasswordRequestJPA = new UserResetPasswordRequest();
        userResetPasswordRequestJPA.setExpirationDate(userResetPasswordRequestCore.getExpirationDate());
        userResetPasswordRequestJPA.setUser(coreUserToUserMapper.mapFromUser());
        return userResetPasswordRequestJPA;
    }
}
