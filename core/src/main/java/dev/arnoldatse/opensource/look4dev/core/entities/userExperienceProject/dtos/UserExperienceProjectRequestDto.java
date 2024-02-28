package dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.dtos;

public class UserExperienceProjectRequestDto {
    private String userExperienceId;
    private String name;
    private String description;
    private String url;

    public String getUserExperienceId() {
        return userExperienceId;
    }

    public void setUserExperienceId(String userExperienceId) {
        this.userExperienceId = userExperienceId;
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
}
