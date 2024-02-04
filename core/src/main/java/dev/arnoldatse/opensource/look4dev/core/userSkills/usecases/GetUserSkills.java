package dev.arnoldatse.opensource.look4dev.core.userSkills.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SimpleSkillResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.mappers.MapperSkillToSimpleSkillResponse;
import dev.arnoldatse.opensource.look4dev.core.userSkills.UserSkillRepository;

import java.util.List;

public class GetUserSkills {
    private final String userId;
    private final UserSkillRepository userSkillRepository;

    public GetUserSkills(String userId, UserSkillRepository userSkillRepository) {
        this.userId = userId;
        this.userSkillRepository = userSkillRepository;
    }

    public List<SimpleSkillResponseDto> execute() {
        List<Skill> skills = userSkillRepository.getUserSkills(userId);
        return skills.stream().map(skill -> new MapperSkillToSimpleSkillResponse(skill).mapFromSkill()).toList();
    }
}
