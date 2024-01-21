package dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform;

import java.util.Date;

public class UrlSupportedPlatform {
    private int id;
    private String name;
    private String label;
    private String logo;
    private Date createdAt;
    private Date updatedAt;

    public UrlSupportedPlatform() {
    }

    public UrlSupportedPlatform(UrlSupportedPlatform urlSupportedPlatform) {
        if (urlSupportedPlatform != null) {
            this.id = urlSupportedPlatform.getId();
            this.name = urlSupportedPlatform.getName();
            this.label = urlSupportedPlatform.getLabel();
            this.logo = urlSupportedPlatform.getLogo();
            this.createdAt = (Date) urlSupportedPlatform.getCreatedAt().clone();
            this.updatedAt = (Date) urlSupportedPlatform.getUpdatedAt().clone();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UrlSupportedPlatform clone() {
        return new UrlSupportedPlatform(this);
    }
}
