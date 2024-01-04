package dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform;

import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.dtos.UserUrlOtherPlatformRequestResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.dtos.UserUrlSupportedPlatformRequestResponseDto;

import java.util.List;

public class UserUrlPlatforms {
    private List<UserUrlOtherPlatform> urlOtherPlatforms;
    private List<UserUrlSupportedPlatform> urlSupportedPlatforms;

    public List<UserUrlOtherPlatform> getUrlOtherPlatforms() {
        return urlOtherPlatforms;
    }

    public void setUrlOtherPlatforms(List<UserUrlOtherPlatform> otherUrlPlatforms) {
        this.urlOtherPlatforms = otherUrlPlatforms;
    }

    public List<UserUrlSupportedPlatform> getUrlSupportedPlatforms() {
        return urlSupportedPlatforms;
    }

    public void setUrlSupportedPlatforms(List<UserUrlSupportedPlatform> urlSupportedPlatforms) {
        this.urlSupportedPlatforms = urlSupportedPlatforms;
    }
}
