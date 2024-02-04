package dev.arnoldatse.opensource.look4dev.core.userSkills.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SimpleSkillResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.mappers.MapperSkillToSimpleSkillResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.userSkills.UserSkillRepository;

import java.util.List;

public class GetUserSkills extends UserSkillsUseCases {
    private final String userId;
    private final UserSkillRepository userSkillRepository;

    public GetUserSkills(String userId, List<UserProfileName> userProfileNames, UserSkillRepository userSkillRepository) {
        super(userProfileNames);
        this.userId = userId;
        this.userSkillRepository = userSkillRepository;
    }

    public List<SimpleSkillResponseDto> execute() throws ForbiddenException {
        checkUserSkillsActionsAuthorized();
        List<Skill> skills = userSkillRepository.getUserSkills(userId);
        return skills.stream().map(skill -> new MapperSkillToSimpleSkillResponse(skill).mapFromSkill()).toList();
    }
}
