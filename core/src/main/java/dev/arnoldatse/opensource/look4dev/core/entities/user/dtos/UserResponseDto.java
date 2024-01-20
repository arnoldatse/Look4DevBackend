package dev.arnoldatse.opensource.look4dev.core.entities.user.dtos;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.dtos.UserProfileResponseDto;

import java.util.Date;
import java.util.List;

public class UserResponseDto {
    private String id;
    private String lastname;
    private String firstname;
    private String email;
    private String pseudo;
    private String pictureUrl;
    private String bio;
    private String cvUrl;
    private Date createdAt;
    private Date updatedAt;
    private List<UserProfileResponseDto> userProfiles;

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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String picture) {
        this.pictureUrl = picture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(String cv) {
        this.cvUrl = cv;
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

    public List<UserProfileResponseDto> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfileResponseDto> userProfiles) {
        this.userProfiles = userProfiles;
    }
}
