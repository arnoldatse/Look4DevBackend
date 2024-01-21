package dev.arnoldatse.opensource.look4dev.core.entities.userProfile;

import java.util.Date;

public class UserProfile {
    private int id;

    private UserProfileName name;

    private Date createdAt;

    public UserProfile() {
    }

    public UserProfile(UserProfile userProfile) {
        if(userProfile!=null){
            this.id = userProfile.getId();
            this.name = userProfile.getName();
            this.createdAt = (Date) userProfile.getCreatedAt().clone();
        }
    }

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

    public UserProfile clone(){
        return new UserProfile(this);
    }
}
