package dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.dtos;

public class UserUrlSupportedPlatformRequestResponseDto {
    private int urlSupportedPlatformId;
    private String url;

    public int getUrlSupportedPlatformId() {
        return urlSupportedPlatformId;
    }

    public void setUrlSupportedPlatformId(int supportedPlatformId) {
        this.urlSupportedPlatformId = supportedPlatformId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
