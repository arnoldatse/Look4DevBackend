package dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.dtos;

import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.dtos.UserUrlOtherPlatformRequestResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.dtos.UserUrlSupportedPlatformRequestResponseDto;

import java.util.List;

public class UserUrlPlatformsRequestResponseDto {

    private List<UserUrlOtherPlatformRequestResponseDto> urlOtherPlatforms;
    private List<UserUrlSupportedPlatformRequestResponseDto> urlSupportedPlatforms;

    public List<UserUrlOtherPlatformRequestResponseDto> getUrlOtherPlatforms() {
        return urlOtherPlatforms;
    }

    public void setUrlOtherPlatforms(List<UserUrlOtherPlatformRequestResponseDto> urlOtherPlatforms) {
        this.urlOtherPlatforms = urlOtherPlatforms;
    }

    public List<UserUrlSupportedPlatformRequestResponseDto> getUrlSupportedPlatforms() {
        return urlSupportedPlatforms;
    }

    public void setUrlSupportedPlatforms(List<UserUrlSupportedPlatformRequestResponseDto> urlSupportedPlatforms) {
        this.urlSupportedPlatforms = urlSupportedPlatforms;
    }
}
