package dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.UserExperienceProject;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.dtos.UserExperienceProjectResponseDto;

public class MapperUserExperienceProjectToUserExperienceProjectResponse implements MapperFromUserExperienceProject<UserExperienceProjectResponseDto>{
    private final UserExperienceProject userExperienceProject;

    public MapperUserExperienceProjectToUserExperienceProjectResponse(UserExperienceProject userExperienceProject) {
        this.userExperienceProject = userExperienceProject;
    }

    @Override
    public UserExperienceProjectResponseDto mapFromUserExperienceProject() {
        UserExperienceProjectResponseDto userExperienceProjectResponse = new UserExperienceProjectResponseDto();
        userExperienceProjectResponse.setId(userExperienceProject.getId());
        userExperienceProjectResponse.setName(userExperienceProject.getName());
        userExperienceProjectResponse.setDescription(userExperienceProject.getDescription());
        userExperienceProjectResponse.setUrl(userExperienceProject.getUrl());
        userExperienceProjectResponse.setScreenshots(userExperienceProject.getScreenshots());
        return userExperienceProjectResponse;
    }
}
