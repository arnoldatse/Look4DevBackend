package dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.UserUrlPlatforms;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.dtos.UserUrlPlatformsRequestResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.dtos.UserUrlOtherPlatformRequestResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.mappers.MapperUserUrlOtherPlatformToUserUrlOtherPlatformRequestResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.dtos.UserUrlSupportedPlatformRequestResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.mappers.MapperUserUrlSupportedPlatformToUserUrlSupportedPlatformRequestResponse;

public class MapperUserUrlPlatformsToUserUrlPlatformsRequestResponse implements MapperFromUserUrlPlatforms<UserUrlPlatformsRequestResponseDto>{
    private final UserUrlPlatforms userUrlPlatforms;

    public MapperUserUrlPlatformsToUserUrlPlatformsRequestResponse(UserUrlPlatforms userUrlPlatforms) {
        this.userUrlPlatforms = userUrlPlatforms;
    }

    @Override
    public UserUrlPlatformsRequestResponseDto mapFromUserUrlPlatforms() {
        UserUrlPlatformsRequestResponseDto mappedUserUrlPlatformsRequestResponse = new UserUrlPlatformsRequestResponseDto();
        mappedUserUrlPlatformsRequestResponse.setUrlOtherPlatforms(userUrlPlatforms.getUrlOtherPlatforms().stream().map(this::mapUserUrlOtherPlatformToUserUrlOtherPlatformRequestResponse).toList());
        mappedUserUrlPlatformsRequestResponse.setUrlSupportedPlatforms(userUrlPlatforms.getUrlSupportedPlatforms().stream().map(this::mapUserUrlSupportedPlatformToUserUrlSupportedPlatformRequestResponse).toList());
        return mappedUserUrlPlatformsRequestResponse;
    }

    private UserUrlOtherPlatformRequestResponseDto mapUserUrlOtherPlatformToUserUrlOtherPlatformRequestResponse(UserUrlOtherPlatform userUrlOtherPlatform){
        return new MapperUserUrlOtherPlatformToUserUrlOtherPlatformRequestResponse(userUrlOtherPlatform).mapFromUserUrlOtherPlatform();
    }

    private UserUrlSupportedPlatformRequestResponseDto mapUserUrlSupportedPlatformToUserUrlSupportedPlatformRequestResponse(UserUrlSupportedPlatform userUrlSupportedPlatform){
        return new MapperUserUrlSupportedPlatformToUserUrlSupportedPlatformRequestResponse(userUrlSupportedPlatform).mapFromUserUrlSupportedPlatform();
    }
}
