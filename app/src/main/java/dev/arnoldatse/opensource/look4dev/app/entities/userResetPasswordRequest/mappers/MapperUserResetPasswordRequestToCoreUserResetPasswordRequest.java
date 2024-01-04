package dev.arnoldatse.opensource.look4dev.app.entities.userResetPasswordRequest.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.user.mappers.MapperUserToCoreUser;
import dev.arnoldatse.opensource.look4dev.app.entities.userResetPasswordRequest.UserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperToUser;
import dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.mappers.MapperToUserResetPasswordRequest;

public class MapperUserResetPasswordRequestToCoreUserResetPasswordRequest implements MapperToUserResetPasswordRequest {
    private final UserResetPasswordRequest userResetPasswordRequest;

    public MapperUserResetPasswordRequestToCoreUserResetPasswordRequest(UserResetPasswordRequest userResetPasswordRequest){
        this.userResetPasswordRequest = userResetPasswordRequest;
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest mapToUserResetPasswordRequest() {
        MapperToUser userToCoreUserMapper = new MapperUserToCoreUser(userResetPasswordRequest.getUser());
        return new dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest(
                userResetPasswordRequest.getId(),
                userResetPasswordRequest.getExpirationDate(),
                userResetPasswordRequest.getCreatedAt(),
                userToCoreUserMapper.mapToUser()
        );
    }
}
