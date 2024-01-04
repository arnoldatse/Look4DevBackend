package dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.dtos.UserUrlSupportedPlatformRequestResponseDto;

public class MapperUserUrlSupportedPlatformToUserUrlSupportedPlatformRequestResponse implements MapperFromUserUrlSupportedPlatform<UserUrlSupportedPlatformRequestResponseDto>{
    private final UserUrlSupportedPlatform userUrlSupportedPlatform;
    public MapperUserUrlSupportedPlatformToUserUrlSupportedPlatformRequestResponse(UserUrlSupportedPlatform userUrlSupportedPlatform){
        this.userUrlSupportedPlatform = userUrlSupportedPlatform;
    }

    @Override
    public UserUrlSupportedPlatformRequestResponseDto mapFromUserUrlSupportedPlatform() {
        UserUrlSupportedPlatformRequestResponseDto userUrlSupportedPlatformRequestResponse = new UserUrlSupportedPlatformRequestResponseDto();
        userUrlSupportedPlatformRequestResponse.setUrlSupportedPlatformId(userUrlSupportedPlatform.getUrlSupportedPlatform().getId());
        userUrlSupportedPlatformRequestResponse.setUrl(userUrlSupportedPlatform.getUrl());
        return userUrlSupportedPlatformRequestResponse;
    }
}
