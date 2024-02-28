package dev.arnoldatse.opensource.look4dev.core.entities.userExperience.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.mappers.MapperSkillToSimpleSkillResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.UserExperience;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.dtos.UserExperienceResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.mappers.MapperUserExperienceProjectToUserExperienceProjectResponse;

public class MapperUserExperienceToUserExperienceResponse implements MapperFromUserExperience<UserExperienceResponseDto>{
    private final UserExperience userExperience;

    public MapperUserExperienceToUserExperienceResponse(UserExperience userExperience) {
        this.userExperience = userExperience;
    }

    @Override
    public UserExperienceResponseDto mapFromUserExperience() {
        UserExperienceResponseDto userExperienceResponse = new UserExperienceResponseDto();
        userExperienceResponse.setCompany(userExperience.getCompany());
        userExperienceResponse.setTitle(userExperience.getTitle());
        userExperienceResponse.setDescription(userExperience.getDescription());
        userExperienceResponse.setStartDate(userExperience.getStartDate());
        userExperienceResponse.setEndDate(userExperience.getEndDate());
        userExperienceResponse.setCurrent(userExperience.isCurrent());
        userExperienceResponse.setProjects(userExperience.getProjects().stream()
                .map(project -> new MapperUserExperienceProjectToUserExperienceProjectResponse(project)
                        .mapFromUserExperienceProject()).toList());
        userExperienceResponse.setSkills(userExperience.getSkills()
                .stream()
                .map(skill -> new MapperSkillToSimpleSkillResponse(skill).mapFromSkill())
                .toList());
        return userExperienceResponse;
    }
}
