package dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.dtos;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;

public class UserExperienceProjectResponseDto {
    private String id;
    private String name;
    private String description;
    private String url;
    private String[] screenshots;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String[] getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(String[] screenshots) {
        this.screenshots = screenshots;
    }
}
