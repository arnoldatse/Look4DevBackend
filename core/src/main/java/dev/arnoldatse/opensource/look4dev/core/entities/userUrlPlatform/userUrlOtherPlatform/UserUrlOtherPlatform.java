package dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform;

import java.util.Date;

public class UserUrlOtherPlatform {
    private String id;
    private String url;
    private String label;
    private Date createdAt;

    public UserUrlOtherPlatform() {
    }

    public UserUrlOtherPlatform(UserUrlOtherPlatform userUrlOtherPlatform) {
        if (userUrlOtherPlatform != null) {
            this.id = userUrlOtherPlatform.getId();
            this.url = userUrlOtherPlatform.getId();
            this.label = userUrlOtherPlatform.getId();
            this.createdAt = (Date) userUrlOtherPlatform.getCreatedAt().clone();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UserUrlOtherPlatform clone() {
        return new UserUrlOtherPlatform(this);
    }
}
