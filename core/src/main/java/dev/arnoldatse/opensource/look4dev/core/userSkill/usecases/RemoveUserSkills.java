package dev.arnoldatse.opensource.look4dev.core.userSkill.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SimpleSkillResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SkillsRequestIdsDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.mappers.MapperSkillToSimpleSkillResponse;
import dev.arnoldatse.opensource.look4dev.core.userSkill.UserSkillRepository;

import java.util.List;

public class RemoveUserSkills {
    private final String userId;
    private final SkillsRequestIdsDto skillsRequestIds;
    private final UserSkillRepository userSkillRepository;

    public RemoveUserSkills(String userId, SkillsRequestIdsDto skillsRequestIds, UserSkillRepository userSkillRepository) {
        this.userId = userId;
        this.skillsRequestIds = skillsRequestIds;
        this.userSkillRepository = userSkillRepository;
    }

    public List<SimpleSkillResponseDto> execute() {
        List<Skill> skills = userSkillRepository.removeUserSkills(userId, skillsRequestIds);
        return skills.stream().map(skill -> new MapperSkillToSimpleSkillResponse(skill).mapFromSkill()).toList();
    }
}
