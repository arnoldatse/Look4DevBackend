package dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlSupportedPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.urlSupportedPlatform.mappers.MapperCoreUrlSupportedPlatformToUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlSupportedPlatform.UserUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.UrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.mappers.MapperFromUserUrlSupportedPlatform;

public class MapperCoreUserUrlSupportedPlatformToUserUrlSupportedPlatform implements MapperFromUserUrlSupportedPlatform<UserUrlSupportedPlatform> {
    private final dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform coreUserUrlSupportedPlatform;

    public MapperCoreUserUrlSupportedPlatformToUserUrlSupportedPlatform(dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform coreUserUrlSupportedPlatform) {
        this.coreUserUrlSupportedPlatform = coreUserUrlSupportedPlatform;
    }

    @Override
    public UserUrlSupportedPlatform mapFromUserUrlSupportedPlatform() {
        UserUrlSupportedPlatform mappedUserUrlSupportedPlatform = new UserUrlSupportedPlatform();
        mappedUserUrlSupportedPlatform.setId(coreUserUrlSupportedPlatform.getId());
        mappedUserUrlSupportedPlatform.setUrl(coreUserUrlSupportedPlatform.getUrl());
        mappedUserUrlSupportedPlatform.setCreatedAt(coreUserUrlSupportedPlatform.getCreatedAt());

        UrlSupportedPlatform urlSupportedPlatform = coreUserUrlSupportedPlatform.getUrlSupportedPlatform();
        if(urlSupportedPlatform != null){
            mappedUserUrlSupportedPlatform.setSupportedPlatform(
                    new MapperCoreUrlSupportedPlatformToUrlSupportedPlatform(urlSupportedPlatform).mapFromUrlSupportedPlatform()
            );
        }

        return mappedUserUrlSupportedPlatform;
    }


}
