package dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlOtherPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlOtherPlatform.UserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.mappers.MapperFromUserUrlOtherPlatform;

public class MapperCoreUserUrlOtherPlatformToUserUrlOtherPlatform implements MapperFromUserUrlOtherPlatform<UserUrlOtherPlatform> {
    private final dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform coreUserUrlOtherPlatform;

    public MapperCoreUserUrlOtherPlatformToUserUrlOtherPlatform(dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform coreUserUrlOtherPlatform) {
        this.coreUserUrlOtherPlatform = coreUserUrlOtherPlatform;
    }

    @Override
    public UserUrlOtherPlatform mapFromUserUrlOtherPlatform() {
        UserUrlOtherPlatform mappedUserUrlOtherPlatform = new UserUrlOtherPlatform();
        mappedUserUrlOtherPlatform.setId(coreUserUrlOtherPlatform.getId());
        mappedUserUrlOtherPlatform.setLabel(coreUserUrlOtherPlatform.getLabel());
        mappedUserUrlOtherPlatform.setUrl(coreUserUrlOtherPlatform.getUrl());
        mappedUserUrlOtherPlatform.setCreatedAt(coreUserUrlOtherPlatform.getCreatedAt());
        return mappedUserUrlOtherPlatform;
    }
}
