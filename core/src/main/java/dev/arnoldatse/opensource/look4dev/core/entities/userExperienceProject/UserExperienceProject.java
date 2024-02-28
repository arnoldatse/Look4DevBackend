package dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.UserExperience;

public class UserExperienceProject {
    private String id;
    private UserExperience userExperience;
    private String name;
    private String description;
    private String url;
    private User user;
    private String[] screenshots;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserExperience getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(UserExperience userExperience) {
        this.userExperience = userExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(String[] screenshots) {
        this.screenshots = screenshots;
    }
}
