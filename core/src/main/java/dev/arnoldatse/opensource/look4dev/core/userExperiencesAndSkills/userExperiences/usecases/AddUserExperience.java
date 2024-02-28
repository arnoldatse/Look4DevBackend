package dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userExperiences.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.UserExperience;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.dtos.UserExperienceAddRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.dtos.UserExperienceResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.mappers.MapperUserExperienceAddRequestToUserExperience;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.mappers.MapperUserExperienceToUserExperienceResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.UserExperiencesAndSkillsUseCases;
import dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userExperiences.UserExperienceRepository;
import dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userSkills.UserSkillRepository;
import dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userSkills.usecases.AddUserSkills;

import java.util.List;

public class AddUserExperience extends UserExperiencesAndSkillsUseCases {
    private final String userId;
    private final UserExperienceRepository userExperienceRepository;
    private final UserSkillRepository userSkillRepository;
    private final UserExperienceAddRequestDto userExperienceRequest;

    public AddUserExperience(String userId,
                             List<UserProfileName> userProfileNames,
                             UserExperienceRepository userExperienceRepository,
                             UserSkillRepository userSkillRepository,
                             UserExperienceAddRequestDto userExperienceRequest) {
        super(userProfileNames);
        this.userId = userId;
        this.userSkillRepository = userSkillRepository;
        this.userExperienceRepository = userExperienceRepository;
        this.userExperienceRequest = userExperienceRequest;
    }
    public UserExperienceResponseDto execute() throws ForbiddenException {
        checkUserExperiencesAndSkillsActionsAuthorized();

        UserExperience savedUserExperience = saveUserExperience();
        new AddUserSkills(userId, userProfilesNames, userExperienceRequest.getSkills(), userSkillRepository)
                .execute(true);
        return new MapperUserExperienceToUserExperienceResponse(savedUserExperience)
                .mapFromUserExperience();
    }

    private UserExperience saveUserExperience(){
        UserExperience userExperience = new MapperUserExperienceAddRequestToUserExperience(userExperienceRequest)
                .mapToUserExperience();
        User user = new User();
        user.setId(userId);
        userExperience.setUser(user);
        return userExperienceRepository.save(userExperience);
    }
}
