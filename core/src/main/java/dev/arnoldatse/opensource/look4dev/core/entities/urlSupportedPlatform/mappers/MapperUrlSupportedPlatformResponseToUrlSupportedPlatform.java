package dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.UrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.dtos.UrlSupportedPlatformResponseDto;

public class MapperUrlSupportedPlatformResponseToUrlSupportedPlatform implements MapperToUrlSupportedPlatform{
    private final UrlSupportedPlatformResponseDto urlSupportedPlatformResponseDto;

    public MapperUrlSupportedPlatformResponseToUrlSupportedPlatform(UrlSupportedPlatformResponseDto urlSupportedPlatformResponseDto) {
        this.urlSupportedPlatformResponseDto = urlSupportedPlatformResponseDto;
    }

    @Override
    public UrlSupportedPlatform mapToUrlSupportedPlatform() {
        UrlSupportedPlatform mappedUrlSupportedPlatform = new UrlSupportedPlatform();
        mappedUrlSupportedPlatform.setId(urlSupportedPlatformResponseDto.getId());
        mappedUrlSupportedPlatform.setLabel(urlSupportedPlatformResponseDto.getLabel());
        mappedUrlSupportedPlatform.setLogo(urlSupportedPlatformResponseDto.getLogoPath());
        return mappedUrlSupportedPlatform;
    }
}
