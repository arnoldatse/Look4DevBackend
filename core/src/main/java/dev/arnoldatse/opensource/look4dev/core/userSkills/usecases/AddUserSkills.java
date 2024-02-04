package dev.arnoldatse.opensource.look4dev.core.userSkills.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SimpleSkillResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SkillsRequestIdsDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.mappers.MapperSkillToSimpleSkillResponse;
import dev.arnoldatse.opensource.look4dev.core.userSkills.UserSkillRepository;

import java.util.List;

public class AddUserSkills {
    private final String userId;
    private final SkillsRequestIdsDto skillsRequestIds;
    private final UserSkillRepository userSkillRepository;

    public AddUserSkills(String userId, SkillsRequestIdsDto skillsRequestIds, UserSkillRepository userSkillRepository) {
        this.userId = userId;
        this.skillsRequestIds = skillsRequestIds;
        this.userSkillRepository = userSkillRepository;
    }

    public List<SimpleSkillResponseDto> execute() {
        List<Skill> skills = userSkillRepository.addUserSkills(userId, skillsRequestIds.ids());
        return skills.stream().map(skill -> new MapperSkillToSimpleSkillResponse(skill).mapFromSkill()).toList();
    }
}
