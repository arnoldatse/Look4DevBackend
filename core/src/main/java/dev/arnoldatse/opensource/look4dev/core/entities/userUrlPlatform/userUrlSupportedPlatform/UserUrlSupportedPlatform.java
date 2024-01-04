package dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform;

import dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.UrlSupportedPlatform;

import java.util.Date;

public class UserUrlSupportedPlatform {
    private String id;
    private UrlSupportedPlatform urlSupportedPlatform;
    private String url;
    private Date createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UrlSupportedPlatform getUrlSupportedPlatform() {
        return urlSupportedPlatform;
    }

    public void setUrlSupportedPlatform(UrlSupportedPlatform urlSupportedPlatform) {
        this.urlSupportedPlatform = urlSupportedPlatform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
