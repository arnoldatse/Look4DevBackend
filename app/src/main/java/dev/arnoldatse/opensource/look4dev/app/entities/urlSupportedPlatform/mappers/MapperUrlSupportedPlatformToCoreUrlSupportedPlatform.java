package dev.arnoldatse.opensource.look4dev.app.entities.urlSupportedPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.urlSupportedPlatform.UrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.mappers.MapperToUrlSupportedPlatform;

public class MapperUrlSupportedPlatformToCoreUrlSupportedPlatform implements MapperToUrlSupportedPlatform {
    private final UrlSupportedPlatform urlSupportedPlatform;

    public MapperUrlSupportedPlatformToCoreUrlSupportedPlatform(UrlSupportedPlatform urlSupportedPlatform) {
        this.urlSupportedPlatform = urlSupportedPlatform;
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.UrlSupportedPlatform mapToUrlSupportedPlatform() {
        dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.UrlSupportedPlatform mappedCoreUrlSupportedPlatform = new dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.UrlSupportedPlatform();
        mappedCoreUrlSupportedPlatform.setId(urlSupportedPlatform.getId());
        mappedCoreUrlSupportedPlatform.setName(urlSupportedPlatform.getName());
        mappedCoreUrlSupportedPlatform.setLabel(urlSupportedPlatform.getLabel());
        mappedCoreUrlSupportedPlatform.setLogo(urlSupportedPlatform.getLogoPath());
        mappedCoreUrlSupportedPlatform.setUpdatedAt(urlSupportedPlatform.getUpdatedAt());
        mappedCoreUrlSupportedPlatform.setCreatedAt(urlSupportedPlatform.getCreatedAt());
        return mappedCoreUrlSupportedPlatform;
    }
}
