package dev.arnoldatse.opensource.look4dev.app.entities.urlSupportedPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.urlSupportedPlatform.UrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.mappers.MapperFromUrlSupportedPlatform;

public class MapperCoreUrlSupportedPlatformToUrlSupportedPlatform implements MapperFromUrlSupportedPlatform<UrlSupportedPlatform> {
    private final dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.UrlSupportedPlatform coreUrlSupportedPlatform;

    public MapperCoreUrlSupportedPlatformToUrlSupportedPlatform(dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.UrlSupportedPlatform coreUrlSupportedPlatform) {
        this.coreUrlSupportedPlatform = coreUrlSupportedPlatform;
    }

    @Override
    public UrlSupportedPlatform mapFromUrlSupportedPlatform() {
        UrlSupportedPlatform mappedUrlSupportedPlatform = new UrlSupportedPlatform();
        mappedUrlSupportedPlatform.setId(coreUrlSupportedPlatform.getId());
        mappedUrlSupportedPlatform.setName(coreUrlSupportedPlatform.getName());
        mappedUrlSupportedPlatform.setLabel(coreUrlSupportedPlatform.getLabel());
        mappedUrlSupportedPlatform.setLogoPath(coreUrlSupportedPlatform.getLogo());
        mappedUrlSupportedPlatform.setUpdatedAt(coreUrlSupportedPlatform.getUpdatedAt());
        mappedUrlSupportedPlatform.setCreatedAt(coreUrlSupportedPlatform.getCreatedAt());
        return mappedUrlSupportedPlatform;
    }
}
