package dev.arnoldatse.opensource.look4dev.core.userSkills.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SimpleSkillResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SkillsRequestIdsDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.mappers.MapperSkillToSimpleSkillResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.userSkills.UserSkillRepository;

import java.util.List;

public class RemoveUserSkills extends UserSkillsUseCases {
    private final String userId;
    private final SkillsRequestIdsDto skillsRequestIds;
    private final UserSkillRepository userSkillRepository;

    public RemoveUserSkills(String userId, List<UserProfileName> userProfileNames, SkillsRequestIdsDto skillsRequestIds, UserSkillRepository userSkillRepository) {
        super(userProfileNames);
        this.userId = userId;
        this.skillsRequestIds = skillsRequestIds;
        this.userSkillRepository = userSkillRepository;
    }

    public List<SimpleSkillResponseDto> execute() throws ForbiddenException {
        checkUserSkillsActionsAuthorized();
        List<Skill> skills = userSkillRepository.removeUserSkills(userId, skillsRequestIds.ids());
        return skills.stream().map(skill -> new MapperSkillToSimpleSkillResponse(skill).mapFromSkill()).toList();
    }
}
