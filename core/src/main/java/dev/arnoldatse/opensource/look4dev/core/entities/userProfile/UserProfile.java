package dev.arnoldatse.opensource.look4dev.core.entities.userProfile;

import dev.arnoldatse.opensource.look4dev.core.entities.user.UserWithIntegralUserProfile;

import java.util.Date;
import java.util.List;

public class UserProfile {
    private int id;

    private UserProfileName name;

    private Date createdAt;

    private List<UserWithIntegralUserProfile> userWithIntegralUserProfiles;

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

    public List<UserWithIntegralUserProfile> getUsers() {
        return userWithIntegralUserProfiles;
    }

    public void addUser(UserWithIntegralUserProfile userWithIntegralUserProfile) {
        userWithIntegralUserProfile.addUserProfile(this);
        userWithIntegralUserProfiles.add(userWithIntegralUserProfile);
    }

    public void setUsers(List<UserWithIntegralUserProfile> userWithIntegralUserProfiles) {
        this.userWithIntegralUserProfiles = userWithIntegralUserProfiles;
    }
}
