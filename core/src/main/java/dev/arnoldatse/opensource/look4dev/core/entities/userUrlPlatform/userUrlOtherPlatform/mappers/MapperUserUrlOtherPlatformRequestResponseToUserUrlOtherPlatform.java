package dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.dtos.UserUrlOtherPlatformRequestResponseDto;

public class MapperUserUrlOtherPlatformRequestResponseToUserUrlOtherPlatform implements MapperToUserUrlOtherPlatform{
    private UserUrlOtherPlatformRequestResponseDto userUrlOtherPlatformRequestResponseDto;

    public MapperUserUrlOtherPlatformRequestResponseToUserUrlOtherPlatform(UserUrlOtherPlatformRequestResponseDto userUrlOtherPlatformRequestResponseDto) {
        this.userUrlOtherPlatformRequestResponseDto = userUrlOtherPlatformRequestResponseDto;
    }

    @Override
    public UserUrlOtherPlatform mapToUserUrlOtherPlatform() {
        UserUrlOtherPlatform mappedUserUrlOtherPlatform = new UserUrlOtherPlatform();
        mappedUserUrlOtherPlatform.setUrl(userUrlOtherPlatformRequestResponseDto.getUrl());
        mappedUserUrlOtherPlatform.setLabel(userUrlOtherPlatformRequestResponseDto.getLabel());
        return mappedUserUrlOtherPlatform;
    }
}
