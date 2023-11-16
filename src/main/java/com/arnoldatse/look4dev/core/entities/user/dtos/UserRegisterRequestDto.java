package com.arnoldatse.look4dev.core.entities.user.dtos;

import java.util.Arrays;

public class UserRegisterRequestDto {
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private int[] userProfilesIds;

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

    public int[] getUserProfilesIds() {
        return userProfilesIds;
    }

    public void setUserProfilesIds(int[] userProfilesIds) {
        this.userProfilesIds = userProfilesIds;
    }

    @Override
    public String toString() {
        return "UserRegisterRequestDto{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userProfilesIds=" + Arrays.toString(userProfilesIds) +
                '}';
    }
}
