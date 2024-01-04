package dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.UrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.dtos.UserUrlSupportedPlatformRequestResponseDto;

public class MapperUserUrlSupportedPlatformRequestResponseToUserUrlSupportedPlatform implements MapperToUserUrlSupportedPlatform{
    private final UserUrlSupportedPlatformRequestResponseDto userUrlSupportedPlatformRequestResponseDto;

    public MapperUserUrlSupportedPlatformRequestResponseToUserUrlSupportedPlatform(UserUrlSupportedPlatformRequestResponseDto userUrlSupportedPlatformRequestResponseDto) {
        this.userUrlSupportedPlatformRequestResponseDto = userUrlSupportedPlatformRequestResponseDto;
    }

    @Override
    public UserUrlSupportedPlatform mapToUserUrlSupportedPlatform() {
        UserUrlSupportedPlatform mappedUserUrlSupportedPlatform = new UserUrlSupportedPlatform();
        mappedUserUrlSupportedPlatform.setUrlSupportedPlatform(generateUrlSupportedPlatform());
        mappedUserUrlSupportedPlatform.setUrl(userUrlSupportedPlatformRequestResponseDto.getUrl());
        return mappedUserUrlSupportedPlatform;
    }

    private UrlSupportedPlatform generateUrlSupportedPlatform(){
        UrlSupportedPlatform urlSupportedPlatform = new UrlSupportedPlatform();
        urlSupportedPlatform.setId(userUrlSupportedPlatformRequestResponseDto.getUrlSupportedPlatformId());
        return urlSupportedPlatform;
    }
}
