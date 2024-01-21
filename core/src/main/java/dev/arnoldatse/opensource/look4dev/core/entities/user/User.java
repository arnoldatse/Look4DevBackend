package dev.arnoldatse.opensource.look4dev.core.entities.user;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.UserUrlPlatforms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
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
    private List<UserProfile> userProfiles = new ArrayList<>();
    private UserUrlPlatforms platformsUrls = new UserUrlPlatforms(new ArrayList<>(), new ArrayList<>());

    public User() {
    }

    public User(User user) {
        if(user!=null){
            this.id = user.getId();
            this.lastname = user.getLastname();
            this.firstname = user.getFirstname();
            this.email = user.getEmail();
            this.password = user.getPassword();
            this.pseudo = user.getPseudo();
            this.picture = user.getPicture();
            this.bio = user.getBio();
            this.cv = user.getCv();
            this.createdAt = (Date) user.getCreatedAt().clone();
            this.updatedAt = (Date) user.getUpdatedAt().clone();
            this.userProfiles = user.getUserProfiles().stream().map(UserProfile::clone).toList();
            this.platformsUrls = user.platformsUrls.clone();
        }
    }

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
        userProfiles.add(userProfile);
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public UserUrlPlatforms getPlatformsUrls() {
        return platformsUrls;
    }

    public void setPlatformsUrls(UserUrlPlatforms platformsUrls) {
        this.platformsUrls = platformsUrls;
    }

    public User clone(){
        return new User(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", picture='" + picture + '\'' +
                ", bio='" + bio + '\'' +
                ", cv='" + cv + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", userProfiles=" + userProfiles.toString() +
                '}';
    }
}
