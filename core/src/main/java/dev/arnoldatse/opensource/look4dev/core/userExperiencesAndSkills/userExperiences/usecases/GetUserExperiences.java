package dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userExperiences.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.dtos.UserExperienceResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.mappers.MapperUserExperienceToUserExperienceResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.UserExperiencesAndSkillsUseCases;
import dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userExperiences.UserExperienceRepository;

import java.util.List;

public class GetUserExperiences extends UserExperiencesAndSkillsUseCases {
    private final String userId;
    private final UserExperienceRepository userExperienceRepository;

    public GetUserExperiences(String userId,
                              List<UserProfileName> userProfileNames,
                              UserExperienceRepository userExperienceRepository) {
        super(userProfileNames);
        this.userId = userId;
        this.userExperienceRepository = userExperienceRepository;
    }
    public List<UserExperienceResponseDto> execute() throws ForbiddenException {
        checkUserExperiencesAndSkillsActionsAuthorized();
        return userExperienceRepository.findAllByUserId(userId).stream().map(
                userExperience -> new MapperUserExperienceToUserExperienceResponse(userExperience)
                        .mapFromUserExperience()
        ).toList();
    }
}
