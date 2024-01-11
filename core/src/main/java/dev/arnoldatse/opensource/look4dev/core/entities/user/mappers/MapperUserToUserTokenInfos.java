package dev.arnoldatse.opensource.look4dev.core.entities.user.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;

public class MapperUserToUserTokenInfos implements MapperFromUser<UserTokenInfosDto>{
    private final User user;

    public MapperUserToUserTokenInfos(User user) {
        this.user = user;
    }

    @Override
    public UserTokenInfosDto mapFromUser() {
        return new UserTokenInfosDto(user.getId());
    }
}
