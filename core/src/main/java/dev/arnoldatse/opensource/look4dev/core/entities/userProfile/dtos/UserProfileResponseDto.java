package dev.arnoldatse.opensource.look4dev.core.entities.userProfile.dtos;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;

import java.util.Date;

public class UserProfileResponseDto {
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
