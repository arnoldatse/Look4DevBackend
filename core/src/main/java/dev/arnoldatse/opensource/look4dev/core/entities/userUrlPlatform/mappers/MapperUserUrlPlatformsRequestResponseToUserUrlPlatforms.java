package dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.UserUrlPlatforms;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.dtos.UserUrlPlatformsRequestResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.dtos.UserUrlOtherPlatformRequestResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.mappers.MapperUserUrlOtherPlatformRequestResponseToUserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.dtos.UserUrlSupportedPlatformRequestResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.mappers.MapperUserUrlSupportedPlatformRequestResponseToUserUrlSupportedPlatform;

public class MapperUserUrlPlatformsRequestResponseToUserUrlPlatforms implements MapperToUserUrlPlatforms {
    private final UserUrlPlatformsRequestResponseDto userUrlPlatformsRequestResponseDto;

    public MapperUserUrlPlatformsRequestResponseToUserUrlPlatforms(UserUrlPlatformsRequestResponseDto userUrlPlatformsRequestResponseDto) {
        this.userUrlPlatformsRequestResponseDto = userUrlPlatformsRequestResponseDto;
    }

    @Override
    public UserUrlPlatforms mapToUserUrlPlatforms() {
        UserUrlPlatforms mappedUserUrlPlatforms = new UserUrlPlatforms();
        mappedUserUrlPlatforms.setUrlOtherPlatforms(userUrlPlatformsRequestResponseDto.getUrlOtherPlatforms().stream().map(this::mapUserUrlOtherPlatformRequestResponseToUserUrlOtherPlatform).toList());
        mappedUserUrlPlatforms.setUrlSupportedPlatforms(userUrlPlatformsRequestResponseDto.getUrlSupportedPlatforms().stream().map(this::mapUserUrlSupportedPlatformRequestResponseToUserUrlSupportedPlatform).toList());
        return mappedUserUrlPlatforms;
    }

    private UserUrlOtherPlatform mapUserUrlOtherPlatformRequestResponseToUserUrlOtherPlatform(UserUrlOtherPlatformRequestResponseDto userUrlOtherPlatformRequestResponseDto) {
        return new MapperUserUrlOtherPlatformRequestResponseToUserUrlOtherPlatform(userUrlOtherPlatformRequestResponseDto).mapToUserUrlOtherPlatform();
    }

    private UserUrlSupportedPlatform mapUserUrlSupportedPlatformRequestResponseToUserUrlSupportedPlatform(UserUrlSupportedPlatformRequestResponseDto userUrlSupportedPlatformRequestResponseDto) {
        return new MapperUserUrlSupportedPlatformRequestResponseToUserUrlSupportedPlatform(userUrlSupportedPlatformRequestResponseDto).mapToUserUrlSupportedPlatform();
    }
}
