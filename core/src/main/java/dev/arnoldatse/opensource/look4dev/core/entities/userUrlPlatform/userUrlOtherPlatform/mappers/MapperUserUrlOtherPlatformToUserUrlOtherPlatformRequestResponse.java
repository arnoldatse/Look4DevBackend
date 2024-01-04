package dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.dtos.UserUrlOtherPlatformRequestResponseDto;

public class MapperUserUrlOtherPlatformToUserUrlOtherPlatformRequestResponse implements MapperFromUserUrlOtherPlatform<UserUrlOtherPlatformRequestResponseDto> {
    private final UserUrlOtherPlatform userUrlOtherPlatform;
    public MapperUserUrlOtherPlatformToUserUrlOtherPlatformRequestResponse(UserUrlOtherPlatform userUrlOtherPlatform){
        this.userUrlOtherPlatform = userUrlOtherPlatform;
    }

    @Override
    public UserUrlOtherPlatformRequestResponseDto mapFromUserUrlOtherPlatform() {
        UserUrlOtherPlatformRequestResponseDto userUrlOtherPlatformRequestResponse = new UserUrlOtherPlatformRequestResponseDto();
        userUrlOtherPlatformRequestResponse.setUrl(userUrlOtherPlatform.getUrl());
        userUrlOtherPlatformRequestResponse.setLabel(userUrlOtherPlatform.getLabel());
        return userUrlOtherPlatformRequestResponse;
    }
}
