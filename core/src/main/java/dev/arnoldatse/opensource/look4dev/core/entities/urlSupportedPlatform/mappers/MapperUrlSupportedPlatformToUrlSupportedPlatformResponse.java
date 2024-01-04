package dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.UrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.dtos.UrlSupportedPlatformResponseDto;

public class MapperUrlSupportedPlatformToUrlSupportedPlatformResponse implements MapperFromUrlSupportedPlatform<UrlSupportedPlatformResponseDto>{
    private final UrlSupportedPlatform urlSupportedPlatform;

    public MapperUrlSupportedPlatformToUrlSupportedPlatformResponse(UrlSupportedPlatform urlSupportedPlatform) {
        this.urlSupportedPlatform = urlSupportedPlatform;
    }

    @Override
    public UrlSupportedPlatformResponseDto mapFromUrlSupportedPlatform() {
        UrlSupportedPlatformResponseDto mappedUrlSupportedPlatformResponse = new UrlSupportedPlatformResponseDto();
        mappedUrlSupportedPlatformResponse.setId(urlSupportedPlatform.getId());
        mappedUrlSupportedPlatformResponse.setLabel(urlSupportedPlatform.getLabel());
        mappedUrlSupportedPlatformResponse.setLogoPath(urlSupportedPlatform.getLogo());
        return mappedUrlSupportedPlatformResponse;
    }
}
