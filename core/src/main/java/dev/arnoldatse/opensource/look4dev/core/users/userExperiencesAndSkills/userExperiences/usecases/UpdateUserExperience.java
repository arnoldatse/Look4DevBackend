package dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.UserExperience;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.dtos.UserExperienceResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.dtos.UserExperienceUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.mappers.MapperUserExperienceToUserExperienceResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.mappers.MapperUserExperienceUpdateRequestToUserExperience;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.UserExperiencesAndSkillsUseCases;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences.UserExperienceRepository;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences.UserExperienceSkillRespository;

import java.util.List;

public class UpdateUserExperience extends UserExperiencesAndSkillsUseCases {
    private final UserExperienceUpdateRequestDto userExperienceRequest;
    private final UserExperienceRepository userExperienceRepository;
    private final UserExperienceSkillRespository userExperienceSkillRespository;

    protected UpdateUserExperience(List<UserProfileName> userProfileNames,
                                   UserExperienceUpdateRequestDto userExperienceRequest,
                                   UserExperienceRepository userExperienceRepository,
                                   UserExperienceSkillRespository userExperienceSkillRespository) {
        super(userProfileNames);
        this.userExperienceRequest = userExperienceRequest;
        this.userExperienceRepository = userExperienceRepository;
        this.userExperienceSkillRespository = userExperienceSkillRespository;
    }

    public UserExperienceResponseDto execute() throws ForbiddenException {
        checkUserExperiencesAndSkillsActionsAuthorized();

        UserExperience userExperience = new MapperUserExperienceUpdateRequestToUserExperience(userExperienceRequest)
                .mapToUserExperience();
        removeUserExperienceSkills(userExperience);
        return new MapperUserExperienceToUserExperienceResponse(updateUserExperience(userExperience))
                .mapFromUserExperience();
    }

    private UserExperience updateUserExperience(UserExperience userExperience) {
        return userExperienceRepository.update(userExperience);
    }

    private void removeUserExperienceSkills(UserExperience userExperience) {
        userExperienceSkillRespository.deleteAll(userExperience.getId());
    }
}
