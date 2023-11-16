package com.arnoldatse.look4dev.core.entities.userProfile;

import java.util.Date;

/**
 * User profile without list of users
 */
public class UserProfileSimple {
    private int id;

    private String name;

    private Date createdAt;

    public UserProfileSimple(){}
    public UserProfileSimple(int id, String name){
        this.id = id;
        this.name = name;
    }
    public UserProfileSimple(int id){
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
