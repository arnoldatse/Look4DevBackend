package dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userExperiences.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.dtos.UserExperienceResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.UserExperiencesAndSkillsUseCases;
import dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userExperiences.UserExperienceRepository;

import java.util.List;

public class RemoveUserExperience extends UserExperiencesAndSkillsUseCases {
    private final String userId;
    private final String userExperienceId;
    private final UserExperienceRepository userExperienceRepository;

    public RemoveUserExperience(String userId,
                                List<UserProfileName> userProfileNames,
                                String userExperienceId,
                                UserExperienceRepository userExperienceRepository) {
        super(userProfileNames);
        this.userId = userId;
        this.userExperienceId = userExperienceId;
        this.userExperienceRepository = userExperienceRepository;
    }

    public List<UserExperienceResponseDto> execute() throws ForbiddenException {
        checkUserExperiencesAndSkillsActionsAuthorized();
        userExperienceRepository.removeByIdAndUserId(userExperienceId, userId);
        return new GetUserExperiences(userId, userProfilesNames, userExperienceRepository).execute();
    }
}
