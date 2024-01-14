package dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto;

import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.dtos.UserUrlPlatformsRequestResponseDto;

public class UserProfileDetailsResponseDto {
    private String lastname;
    private String firstname;
    private String email;
    private String pseudo;
    private String bio;
    private String picturePath;
    private String cvPath;
    private int[] userProfilesIds;
    private UserUrlPlatformsRequestResponseDto platformsUrls;

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getCvPath() {
        return cvPath;
    }

    public void setCvPath(String cvPath) {
        this.cvPath = cvPath;
    }

    public int[] getUserProfilesIds() {
        return userProfilesIds;
    }

    public void setUserProfilesIds(int[] userProfilesIds) {
        this.userProfilesIds = userProfilesIds;
    }

    public UserUrlPlatformsRequestResponseDto getPlatformsUrls() {
        return platformsUrls;
    }

    public void setPlatformsUrls(UserUrlPlatformsRequestResponseDto userUrlPlatforms) {
        this.platformsUrls = userUrlPlatforms;
    }
}
