package dev.arnoldatse.opensource.look4dev.core.entities.UserResetPasswordRequest;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;

import java.util.Date;

public class UserResetPasswordRequest {
    private String id;
    private Date expirationDate;
    private Date createdAt;
    private User user;

    public UserResetPasswordRequest(){}

    public UserResetPasswordRequest(String id, Date expirationDate, Date createdAt, User user) {
        this.id = id;
        this.expirationDate = expirationDate;
        this.createdAt = createdAt;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }
}
