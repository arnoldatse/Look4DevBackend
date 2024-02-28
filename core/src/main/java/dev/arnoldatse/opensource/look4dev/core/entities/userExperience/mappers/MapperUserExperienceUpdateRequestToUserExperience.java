package dev.arnoldatse.opensource.look4dev.core.entities.userExperience.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.UserExperience;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.dtos.UserExperienceUpdateRequestDto;

import java.util.Arrays;

public class MapperUserExperienceUpdateRequestToUserExperience implements MapperToUserExperience{
    private final UserExperienceUpdateRequestDto userExperienceUpdateRequest;

    public MapperUserExperienceUpdateRequestToUserExperience(UserExperienceUpdateRequestDto userExperienceUpdateRequest) {
        this.userExperienceUpdateRequest = userExperienceUpdateRequest;
    }

    @Override
    public UserExperience mapToUserExperience() {
        UserExperience userExperience = new UserExperience();
        userExperience.setId(userExperienceUpdateRequest.getId());
        userExperience.setCompany(userExperienceUpdateRequest.getCompany());
        userExperience.setTitle(userExperienceUpdateRequest.getTitle());
        userExperience.setDescription(userExperienceUpdateRequest.getDescription());
        userExperience.setStartDate(userExperienceUpdateRequest.getStartDate());
        userExperience.setEndDate(userExperienceUpdateRequest.getEndDate());
        userExperience.setCurrent(userExperienceUpdateRequest.isCurrent());
        userExperience.setSkills(Arrays.stream(userExperienceUpdateRequest.getSkills().ids())
                        .mapToObj(Skill::new).toList());
        return userExperience;
    }
}
