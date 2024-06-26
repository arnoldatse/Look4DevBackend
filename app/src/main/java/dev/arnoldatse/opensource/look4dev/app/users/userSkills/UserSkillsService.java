package dev.arnoldatse.opensource.look4dev.app.users.userSkills;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SkillsRequestIdsDto;
import dev.arnoldatse.opensource.look4dev.app.services.AuthenticatedUserService;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SimpleSkillResponseDto;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userSkills.UserSkillRepository;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userSkills.usecases.AddUserSkills;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userSkills.usecases.GetUserSkills;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userSkills.usecases.RemoveUserSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSkillsService {
    private final AuthenticatedUserService authenticatedUserService;
    private final UserSkillRepository userSkillRepository;

    @Autowired
    public UserSkillsService(AuthenticatedUserService authenticatedUserService, UserSkillRepository userSkillRepository) {
        this.authenticatedUserService = authenticatedUserService;
        this.userSkillRepository = userSkillRepository;
    }

    public List<SimpleSkillResponseDto> getUserSkills() throws ForbiddenException {
        return new GetUserSkills(authenticatedUserService.getAuthenticatedUser().getId(), authenticatedUserService.getAuthenticatedUserProfilesNames(), userSkillRepository).execute();
    }

    public List<SimpleSkillResponseDto> addUserSkills(SkillsRequestIdsDto skillsRequestIdsDto) throws ForbiddenException {
        return new AddUserSkills(authenticatedUserService.getAuthenticatedUser().getId(), authenticatedUserService.getAuthenticatedUserProfilesNames(), skillsRequestIdsDto, userSkillRepository).execute(false);
    }

    public List<SimpleSkillResponseDto> removeUserSkills(SkillsRequestIdsDto skillsRequestIdsDto) throws ForbiddenException {
        return new RemoveUserSkills(authenticatedUserService.getAuthenticatedUser().getId(), authenticatedUserService.getAuthenticatedUserProfilesNames(), skillsRequestIdsDto, userSkillRepository).execute();
    }
}
