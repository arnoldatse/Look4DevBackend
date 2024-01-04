package dev.arnoldatse.opensource.look4dev.core.entities.userProfile;

import java.util.Date;

public class UserProfile {
    private int id;

    private UserProfileName name;

    private Date createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserProfileName getName() {
        return name;
    }

    public void setName(UserProfileName name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
