package dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlSupportedPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.urlSupportedPlatform.UrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.app.entities.urlSupportedPlatform.mappers.MapperUrlSupportedPlatformToCoreUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlSupportedPlatform.UserUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.mappers.MapperToUserUrlSupportedPlatform;

public class MapperUserUrlSupportedPlatformToCoreUserUrlSupportedPlatform implements MapperToUserUrlSupportedPlatform {
    private final UserUrlSupportedPlatform userUrlSupportedPlatform;

    public MapperUserUrlSupportedPlatformToCoreUserUrlSupportedPlatform(UserUrlSupportedPlatform userUrlSupportedPlatform) {
        this.userUrlSupportedPlatform = userUrlSupportedPlatform;
    }


    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform mapToUserUrlSupportedPlatform() {
        dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform mappedCoreUserUrlSupportedPlatform = new dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform();
        mappedCoreUserUrlSupportedPlatform.setId(userUrlSupportedPlatform.getId());
        mappedCoreUserUrlSupportedPlatform.setUrl(userUrlSupportedPlatform.getUrl());
        mappedCoreUserUrlSupportedPlatform.setCreatedAt(userUrlSupportedPlatform.getCreatedAt());
        UrlSupportedPlatform urlSupportedPlatform = userUrlSupportedPlatform.getSupportedPlatform();
        if(urlSupportedPlatform != null){
            mappedCoreUserUrlSupportedPlatform.setUrlSupportedPlatform(new MapperUrlSupportedPlatformToCoreUrlSupportedPlatform(urlSupportedPlatform).mapToUrlSupportedPlatform());
        }

        return mappedCoreUserUrlSupportedPlatform;
    }
}
