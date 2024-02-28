package dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.UserExperienceProject;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.dtos.UserExperienceProjectRequestDto;

public class MapperUserExperienceProjectRequestToUserExperienceProject implements MapperToUserExperienceProject{
    private final UserExperienceProjectRequestDto userExperienceProjectRequest;

    public MapperUserExperienceProjectRequestToUserExperienceProject(UserExperienceProjectRequestDto userExperienceProjectRequest) {
        this.userExperienceProjectRequest = userExperienceProjectRequest;
    }

    @Override
    public UserExperienceProject mapToUserExperienceProject() {
        UserExperienceProject userExperienceProject = new UserExperienceProject();
        userExperienceProject.setName(userExperienceProjectRequest.getName());
        userExperienceProject.setDescription(userExperienceProjectRequest.getDescription());
        userExperienceProject.setUrl(userExperienceProjectRequest.getUrl());
        return userExperienceProject;
    }
}
