package dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userSkills.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SimpleSkillResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SkillsRequestIdsDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.mappers.MapperSkillToSimpleSkillResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.UserExperiencesAndSkillsUseCases;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userSkills.UserSkillRepository;

import java.util.Arrays;
import java.util.List;

public class AddUserSkills extends UserExperiencesAndSkillsUseCases {
    private final String userId;
    private final SkillsRequestIdsDto skillsRequestIds;
    private final UserSkillRepository userSkillRepository;

    public AddUserSkills(String userId, List<UserProfileName> userProfileNames, SkillsRequestIdsDto skillsRequestIds, UserSkillRepository userSkillRepository) {
        super(userProfileNames);
        this.userId = userId;
        this.skillsRequestIds = skillsRequestIds;
        this.userSkillRepository = userSkillRepository;
    }

    public List<SimpleSkillResponseDto> execute(boolean fromExperience) throws ForbiddenException {
        checkUserExperiencesAndSkillsActionsAuthorized();

        List<Skill> skills = userSkillRepository.addUserSkills(userId, filterSkillsToAdd(), fromExperience);
        return skills.stream().map(skill -> new MapperSkillToSimpleSkillResponse(skill).mapFromSkill()).toList();
    }

    private int[] filterSkillsToAdd(){
        return Arrays.stream(skillsRequestIds.ids())
                .filter(skillId -> userSkillRepository.getUserSkills(userId).stream()
                        .noneMatch(userSkill -> userSkill.getId() == skillId))
                .toArray();
    }
}
