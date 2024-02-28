package dev.arnoldatse.opensource.look4dev.core.entities.userExperience.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.UserExperience;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.dtos.UserExperienceAddRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.mappers.MapperUserExperienceProjectRequestToUserExperienceProject;

import java.util.Arrays;

public class MapperUserExperienceAddRequestToUserExperience implements MapperToUserExperience{
    private final UserExperienceAddRequestDto userExperienceAddRequest;

    public MapperUserExperienceAddRequestToUserExperience(UserExperienceAddRequestDto userExperienceAddRequest) {
        this.userExperienceAddRequest = userExperienceAddRequest;
    }

    @Override
    public UserExperience mapToUserExperience() {
        UserExperience userExperience = new UserExperience();
        userExperience.setCompany(userExperienceAddRequest.getCompany());
        userExperience.setTitle(userExperienceAddRequest.getTitle());
        userExperience.setDescription(userExperienceAddRequest.getDescription());
        userExperience.setStartDate(userExperienceAddRequest.getStartDate());
        userExperience.setEndDate(userExperienceAddRequest.getEndDate());
        userExperience.setCurrent(userExperienceAddRequest.isCurrent());
        userExperience.setProjects(userExperienceAddRequest.getProjects().stream()
                .map(project->new MapperUserExperienceProjectRequestToUserExperienceProject(project)
                        .mapToUserExperienceProject()).toList());
        userExperience.setSkills(Arrays.stream(userExperienceAddRequest.getSkills().ids())
                        .mapToObj(Skill::new).toList());
        return userExperience;
    }
}
