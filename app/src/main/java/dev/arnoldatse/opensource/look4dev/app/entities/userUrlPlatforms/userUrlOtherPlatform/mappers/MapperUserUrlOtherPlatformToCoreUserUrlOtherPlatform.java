package dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlOtherPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlOtherPlatform.UserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.mappers.MapperToUserUrlOtherPlatform;

public class MapperUserUrlOtherPlatformToCoreUserUrlOtherPlatform implements MapperToUserUrlOtherPlatform {
    private final UserUrlOtherPlatform userUrlOtherPlatform;

    public MapperUserUrlOtherPlatformToCoreUserUrlOtherPlatform(UserUrlOtherPlatform userUrlOtherPlatform) {
        this.userUrlOtherPlatform = userUrlOtherPlatform;
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform mapToUserUrlOtherPlatform() {
        dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform mappedCoreUserUrlOtherPlatform = new dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform();
        mappedCoreUserUrlOtherPlatform.setId(userUrlOtherPlatform.getId());
        mappedCoreUserUrlOtherPlatform.setLabel(userUrlOtherPlatform.getLabel());
        mappedCoreUserUrlOtherPlatform.setUrl(userUrlOtherPlatform.getUrl());
        mappedCoreUserUrlOtherPlatform.setCreatedAt(userUrlOtherPlatform.getCreatedAt());
        return mappedCoreUserUrlOtherPlatform;
    }
}
