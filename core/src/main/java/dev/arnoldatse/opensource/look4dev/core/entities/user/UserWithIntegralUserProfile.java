package dev.arnoldatse.opensource.look4dev.core.entities.user;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;

import java.util.Date;
import java.util.List;

public class UserWithIntegralUserProfile {
    private String id;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private String pseudo;
    private String picture;
    private String bio;
    private String cv;
    private Date createdAt;
    private Date updatedAt;
    private List<UserProfile> userProfiles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
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

    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void addUserProfile(UserProfile userProfile){
        userProfile.addUser(this);
        userProfiles.add(userProfile);
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }
}
